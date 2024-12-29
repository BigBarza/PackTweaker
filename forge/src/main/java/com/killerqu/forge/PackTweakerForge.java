package com.killerqu.forge;

import com.killerqu.packtweaker.config.ClientConfig;
import com.killerqu.packtweaker.config.CommonConfig;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.ModLoadingContext;

import com.killerqu.packtweaker.PackTweaker;

@Mod(PackTweaker.MOD_ID)
public final class PackTweakerForge {
    public PackTweakerForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(PackTweaker.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);

        // Run our common setup.
        PackTweaker.init();
    }
}
