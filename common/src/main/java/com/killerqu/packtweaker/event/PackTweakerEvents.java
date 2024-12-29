package com.killerqu.packtweaker.event;

import com.killerqu.packtweaker.config.CommonConfig;
import dev.architectury.event.events.common.PlayerEvent;
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
            player.sendMessageToClient(Text.of("This world has rejected you. You have been teleported back."), false);
        }
    }
}
