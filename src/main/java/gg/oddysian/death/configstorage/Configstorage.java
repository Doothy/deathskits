package gg.oddysian.death.configstorage;

import gg.oddysian.death.configstorage.commands.CommandHandout;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;

import gg.oddysian.death.configstorage.handlers.FileHandler;
import gg.oddysian.death.configstorage.config.TestConfig;


@Mod(
        modid = Configstorage.MOD_ID,
        name = Configstorage.MOD_NAME,
        version = Configstorage.VERSION,
        serverSideOnly = true,
        acceptableRemoteVersions = "*"
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
    public void preinit(FMLPreInitializationEvent event) throws IOException {
        log.info("Death's handout plugin has joined the battlefield to give you all the handouts!!!");
        configDir = new File(event.getModConfigurationDirectory() + "//HandoutConfig//");
        configDir.mkdir();
        config = new File(configDir, "config.conf");
        config.createNewFile();


    }

    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event){
        event.registerServerCommand(new CommandHandout());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}









