package ch.capez.dsbg.mixin;

import ch.capez.dsbg.Config;
import net.minecraft.server.level.WorldGenRegion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldGenRegion.class)
public class DsbgWorldGenMixin {
    @Inject(
            method = "ensureCanWrite",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/Util;logAndPauseIfInIde(Ljava/lang/String;)V",
                    ordinal = 0
            ),
            cancellable = true
    )
    private void onEnsureCanWrite(CallbackInfoReturnable<Boolean> ci) {
        if (Config.suppressSpam) {
            ci.setReturnValue(false);
        }
    }
}
