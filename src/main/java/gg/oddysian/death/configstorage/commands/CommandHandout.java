package gg.oddysian.death.configstorage.commands;

import gg.oddysian.death.configstorage.handlers.FileHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

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
        else sender.sendMessage(new TextComponentString("Command can only be run by a player!"));

        if (args[0] == "list"){

            //TODO: list argument is supposed to send a message to the sender, listing all kitnames from kits.json

        }


        //String jsonData = FileHandler.loadConfigFile();
    }
}
