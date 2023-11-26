package ch.capez.dsbg.mixin;

import ch.capez.dsbg.config.DsbgServerConfig;
import net.minecraft.server.level.WorldGenRegion;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WorldGenRegion.class)
public class DetectedSetBlockBeGone {

    @Inject(method = "ensureCanWrite", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/Util;logAndPauseIfInIde(Ljava/lang/String;)V",
            ordinal = 0), cancellable = true)
    private void onEnsureCanWrite(CallbackInfoReturnable<Boolean> ci) {
        if (DsbgServerConfig.SUPPRESS_LOGGING.get()) {
            // cancel prematurely, so string cannot be printed to console
            ci.setReturnValue(false);
        }
    }
}
