package ch.capez.dsbg;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Dsbg.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue SUPPRESS_LOGGING = BUILDER
            .comment("Whether to surpress \"Detected setBlock in a far chunk\" logging")
            .define("suppressSpam", true);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean suppressSpam;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        suppressSpam = SUPPRESS_LOGGING.get();
    }
}
