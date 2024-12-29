package com.killerqu.packtweaker.event;

import com.killerqu.packtweaker.config.CommonConfig;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.PlayerEvent;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

public class DimensionChangeDisableEvent {
    public DimensionChangeDisableEvent INSTANCE = this;
    public void register() {
        PlayerEvent.CHANGE_DIMENSION.register(this::OnDimensionChange);
    }


    private EventResult OnDimensionChange(ServerPlayerEntity serverPlayerEntity, RegistryKey<World> worldRegistryKey, RegistryKey<World> worldRegistryKey1) {
        System.out.println(worldRegistryKey1.getValue().toString());
        System.out.println(CommonConfig.DIMENSION_BLACKLIST.get().contains(worldRegistryKey1.getValue().toString()));
        if (CommonConfig.DIMENSION_BLACKLIST.get().contains(worldRegistryKey1.getValue().toString())) {
            return EventResult.interruptFalse();
        }
        return EventResult.pass();
    }
}
