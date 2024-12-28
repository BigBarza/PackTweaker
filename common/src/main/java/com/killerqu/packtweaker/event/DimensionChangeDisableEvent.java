package com.killerqu.packtweaker.event;

import com.killerqu.packtweaker.config.CommonConfig;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.PlayerEvent;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

public class DimensionChangeDisableEvent {
    public static void register() {
        PlayerEvent.CHANGE_DIMENSION.register(DimensionChangeDisableEvent::OnDimensionChange);
    }


    private static EventResult OnDimensionChange(ServerPlayerEntity serverPlayerEntity, RegistryKey<World> worldRegistryKey, RegistryKey<World> worldRegistryKey1) {
        if (CommonConfig.DIMENSION_BLACKLIST.get().contains(worldRegistryKey1.getValue().toString())) {
            return EventResult.interruptFalse();
        }
        return EventResult.pass();
    }
}
