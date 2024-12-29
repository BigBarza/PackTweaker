package com.killerqu.packtweaker.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

public class CommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> DIMENSION_BLACKLIST;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SLEEP;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_HUNGER;
    public static final ForgeConfigSpec.ConfigValue<Integer> CONSTANT_HUNGER_VALUE;
    static {
        BUILDER.push("PackTweaker config");

        DIMENSION_BLACKLIST = BUILDER.comment("Players won't be able to travel to dimensions listed here.")
                .defineList("Dimension Blacklist", Lists.newArrayList(),s -> s instanceof String);
        ENABLE_SLEEP = BUILDER.comment("If false, player cannot sleep. Setting respawn point will still work.")
                .define("Enable Sleep", true);
        ENABLE_HUNGER = BUILDER.comment("If false, player always has max hunger and saturation. Warning: this will make natural regeneration pretty OP.")
                .define("Enable Hunger", true);
        CONSTANT_HUNGER_VALUE = BUILDER.comment("If hunger was disabled, this amount will be used as your hunger value.")
                .define("Constant Hunger Value", 18);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
