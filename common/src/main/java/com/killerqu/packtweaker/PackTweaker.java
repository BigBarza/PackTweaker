package com.killerqu.packtweaker;

import com.killerqu.packtweaker.event.DimensionChangeDisableEvent;
import com.killerqu.packtweaker.event.PlayerTickEvent;

public final class PackTweaker {
    public static final String MOD_ID = "packtweaker";

    public static void init() {
        DimensionChangeDisableEvent.register();
        PlayerTickEvent.register();
    }
}
