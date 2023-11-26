package ch.capez.dsbg;

import ch.capez.dsbg.config.DsbgServerConfig;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Dsbg.MODID)
public class Dsbg {

    public static final String MODID = "dsbg";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Dsbg() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Load config
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, DsbgServerConfig.SPEC, "dsbg-server.toml");

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> LOGGER.info("DSBG Mod loaded: " + printInitMessage(DsbgServerConfig.SUPPRESS_LOGGING.get())));
    }

    private String printInitMessage(Boolean state) {
        return state ? "SUPPRESSING setBlock error logs!" : "PRINTING setBlock error logs!";
    }

}
