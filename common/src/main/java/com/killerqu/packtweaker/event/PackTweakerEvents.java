package com.killerqu.packtweaker.event;

import com.killerqu.packtweaker.config.CommonConfig;
import dev.architectury.event.events.common.PlayerEvent;
import dev.architectury.event.events.common.TickEvent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.SpawnLocating;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

public class PackTweakerEvents {
    public static void register() {
        PlayerEvent.CHANGE_DIMENSION.register(PackTweakerEvents::onDimensionChange);
        TickEvent.PLAYER_POST.register(PackTweakerEvents::onPlayerTick);
    }

    private static void onPlayerTick(PlayerEntity playerEntity) {
        if (!CommonConfig.ENABLE_HUNGER.get()) {
            playerEntity.getHungerManager().setFoodLevel(CommonConfig.CONSTANT_HUNGER_VALUE.get());
            playerEntity.getHungerManager().setSaturationLevel(20);
        }
    }

    private static void onDimensionChange(ServerPlayerEntity player, RegistryKey<World> worldFrom, RegistryKey<World> worldTo) {
        if (CommonConfig.DIMENSION_BLACKLIST.get().contains(worldTo.getValue().toString())) {
            BlockPos point = player.getSpawnPointPosition();
            if (point != null) {
                player.teleport(player.getServer().getWorld(player.getSpawnPointDimension()), point.getX(), point.getY(), point.getZ(), player.getYaw(), player.getPitch());
            } else {
                point = SpawnLocating.findServerSpawnPoint(player.getServer().getWorld(worldFrom), new ChunkPos(0,0));
                player.teleport(player.getServer().getWorld(player.getSpawnPointDimension()), point.getX(), point.getY(), point.getZ(), player.getYaw(), player.getPitch());
            }
            player.sendMessageToClient(Text.translatable("info.dimension_fail"), false);
        }
    }
}
