package com.killerqu.packtweaker.mixin;

import com.killerqu.packtweaker.config.CommonConfig;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.gui.hud.InGameHud;

@Mixin(value = InGameHud.class, remap = false)
public class InGameHudMixin {
    @ModifyExpressionValue(method="renderStatusBars", at= @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"))
    private int packtweaker$renderHunger(int original) {
        // Minecraft does not render hunger when the entity you are riding has HP (if you are not riding anything, it's 0).
        // We set this HP to 1 if hunger is disabled, which results in the hunger not rendering at all.
        return !CommonConfig.ENABLE_HUNGER.get() ? 1 : original;
    }
}
