package gg.oddysian.death.configstorage;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import gg.oddysian.death.configstorage.handlers.FileHandler;
import gg.oddysian.death.configstorage.config.TestConfig;


@Mod(
        modid = Configstorage.MOD_ID,
        name = Configstorage.MOD_NAME,
        version = Configstorage.VERSION
)
public class Configstorage {

    public static final String MOD_ID = "configstorage";
    public static final String MOD_NAME = "Configstorage";
    public static final String VERSION = "1.0-SNAPSHOT";

    public static Logger log = LogManager.getLogger(MOD_NAME);
    public static File config;
    public static File configDir;

    @Mod.Instance(MOD_ID)
    public static Configstorage INSTANCE;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        configDir = new File(event.getModConfigurationDirectory() + "/");
        config.mkdir();
        config = new File(configDir, "/Configstorage/config.conf");

        FileHandler.loadConfigFile(Configstorage.config);
        FileHandler.existanceCheck();
        FileHandler.writeConfigFile(Configstorage.config);

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}









