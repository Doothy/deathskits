package gg.oddysian.death.deathskits.commands;

import gg.oddysian.death.deathskits.handlers.FileHandler;
import gg.oddysian.death.deathskits.objects.Kit;
import gg.oddysian.death.deathskits.objects.KitStorage;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import gg.oddysian.death.deathskits.config.KitsConfig;

import java.io.File;

public class CommandHandout extends CommandBase {


    @Override
    public String getName() {
        return "handout";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/handout";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        if(sender instanceof EntityPlayerMP)
            sender = (EntityPlayerMP) sender;
        else {
            sender.sendMessage(new TextComponentString("Command can only be run by a player!"));
            return;
        }

        if (args[0] == "list"){
            String msg = "Available kits: ";
            for (Kit kit : KitStorage.kits){
                msg += kit.getName() + " ";
            }
            sender.sendMessage(new TextComponentString(msg));
        }

        if (args[0] != "list" && args[0] != "" && args[0] != null){
            for (int i = 0; i < KitStorage.kitAmount; i++){
                if (KitStorage.kits[i].getName() == args[0]){
                    //TODO: implement a function to actually handout the items
                }
            }
        }

    }

    public void giveKit(Kit kit, EntityPlayerMP sender){

    }
}
