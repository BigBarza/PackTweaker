package com.killerqu.packtweaker.event;

import com.killerqu.packtweaker.config.CommonConfig;
import dev.architectury.event.events.common.TickEvent;
import net.minecraft.entity.player.PlayerEntity;

public class PlayerTickEvent {
    public static void register() {
        TickEvent.PLAYER_POST.register(PlayerTickEvent::onPlayerTick);
    }

    private static void onPlayerTick(PlayerEntity playerEntity) {
        if (!CommonConfig.ENABLE_HUNGER.get()) {
            playerEntity.getHungerManager().setFoodLevel(20);
            playerEntity.getHungerManager().setSaturationLevel(20);
        }
    }
}
