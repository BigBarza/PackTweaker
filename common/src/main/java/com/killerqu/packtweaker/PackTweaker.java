package com.killerqu.packtweaker;

import com.killerqu.packtweaker.event.PackTweakerEvents;

public final class PackTweaker {
    public static final String MOD_ID = "packtweaker";

    public static void init() {
        PackTweakerEvents.register();
    }
}
