package ch.capez.dsbg;

import ch.capez.dsbg.config.DsbgServerConfig;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Dsbg.MODID)
public class Dsbg {

    public static final String MODID = "dsbg";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Dsbg() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, DsbgServerConfig.SPEC, "dsbg-server.toml");

        modEventBus.addListener(this::onCommonSetup);
        modEventBus.addListener(this::onConfigReload);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onCommonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Loading DSBG...");
    }

    public void onConfigReload(ModConfigEvent.Reloading event) {
        LOGGER.info("DSBG Mod loaded: " + printInitMessage(DsbgServerConfig.SUPPRESS_LOGGING.get()));
    }

    private String printInitMessage(Boolean state) {
        return state ? "SUPPRESSING setBlock error logs!" : "PRINTING setBlock error logs!";
    }

}