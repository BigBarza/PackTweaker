package com.killerqu.packtweaker.mixin;

import com.killerqu.packtweaker.config.CommonConfig;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.gui.hud.InGameHud;

@Mixin(value = InGameHud.class, remap = false)
public class InGameHudMixin {
    @Inject(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;getHeartCount(Lnet/minecraft/entity/LivingEntity;)I"), cancellable = true)
    public void packtweaker$renderStatusBars(MatrixStack matrices, CallbackInfo ci) {
        if (!CommonConfig.ENABLE_HUNGER.get()) {
            ci.cancel();
        }
    }
}
