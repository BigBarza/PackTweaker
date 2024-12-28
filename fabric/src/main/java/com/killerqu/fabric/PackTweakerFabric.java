package com.killerqu.fabric;

import com.killerqu.packtweaker.config.CommonConfig;
import net.fabricmc.api.ModInitializer;

import com.killerqu.packtweaker.PackTweaker;
import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public final class PackTweakerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        PackTweaker.init();
        ModLoadingContext.registerConfig(PackTweaker.MOD_ID, ModConfig.Type.COMMON, CommonConfig.SPEC);
    }
}
