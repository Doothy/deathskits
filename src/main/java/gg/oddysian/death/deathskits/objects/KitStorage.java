package gg.oddysian.death.deathskits.objects;

public class KitStorage {

    public static int kitAmount;
    public static Kit[] kits = new Kit[kitAmount];

    public int getKitAmount(String[] fromJson){
        int i = 0;
        for (Kit kit : fromJson){
            i++;
        }
        return i;
    }

    public String getName(int index){
        return kits[index].getName();
    }

}
