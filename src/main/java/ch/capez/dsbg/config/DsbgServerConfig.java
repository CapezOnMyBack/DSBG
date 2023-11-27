package ch.capez.dsbg.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DsbgServerConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> SUPPRESS_LOGGING;

    static {
        BUILDER.push("Config for -Detected setBlock be gone- Mod");

        SUPPRESS_LOGGING = BUILDER.comment("Should the \"Detected setBlock in a far chunk\" log messages be suppressed?")
                .define("Suppress spam", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
