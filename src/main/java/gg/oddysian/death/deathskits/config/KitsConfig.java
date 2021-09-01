package gg.oddysian.death.deathskits.config;

import gg.oddysian.death.deathskits.objects.Kit;
import gg.oddysian.death.deathskits.objects.Item;
import gg.oddysian.death.deathskits.handlers.FileHandler;

public class KitsConfig {

    public static int kitAmount;
    public static Kit[] kits = new Kit[kitAmount];

    public int getKitAmount(String[] fromJson){
        int i = 0;
        for (Kit kit : fromJson){
            i++;
        }
        return i;
    }

}
