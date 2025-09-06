package ch.capez.dsbg;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = Dsbg.MODID)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue SUPPRESS_LOGGING = BUILDER
            .comment("Whether to suppress \"Detected setBlock in a far chunk\" logging")
            .define("suppressSpam", true);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean suppressSpam;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        suppressSpam = SUPPRESS_LOGGING.get();
    }
}
