package gg.oddysian.death.configstorage.handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gg.oddysian.death.configstorage.Configstorage;
import gg.oddysian.death.configstorage.config.TestConfig;

import javax.security.auth.login.Configuration;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;


public class FileHandler {

    public static File config = Configstorage.config;
    //Check if the config file exists
    public static void existanceCheck(){
        if (config == null)
            config = Configstorage.config;
    }

    //create a file if missing, setup for the Filewriter
    public static void writeConfigFile(File file){
        try {
            if (!file.exists())
                file.createNewFile();
            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
            String json = gson.toJson(config);
            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.close();
        } catch (Exception e){
            Configstorage.log.error("Failure trying to save the config file!" + e.getMessage());
        }

    }

    //load an existing file, if not existing, create one
    public static Gson loadConfigFile(File file){
        try{
            if (!file.exists())
                file.createNewFile();
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(file));
            return gson.fromJson(br, (Type) config);

        } catch (Exception e) {
            Configstorage.log.error("Failure trying to read the config file!" + e.getMessage());
        }
        return null;
    }

}
