package kaikz.has.no.pancake.mix.cmds;

import java.io.FileOutputStream;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import kaikz.has.no.pancake.mix.cmds.base.SubBase;
import kaikz.has.no.pancake.mix.main.InstaServer;

public class MOTD extends SubBase {
	public MOTD(InstaServer pl) {
		super(pl);
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		if (sender.hasPermission("instaserver.motd")) {
        	String message = "";
            for (String s : args) {
                message = message + s + " ";
            }
            message = message.trim();
            plugin.getMinecraftServer().motd = message;
            plugin.getProps().put("motd", message);
            try {
            	plugin.getProps().store(new FileOutputStream(plugin.getPropsPath()), null);
    			plugin.send(sender, plugin.info + "Set new MOTD.");
    		} catch (IOException e) {
    			plugin.send(sender, plugin.error + "Failed to save properties.");
    		}
        } else {
        	plugin.send(sender, plugin.error + ChatColor.RED + "You don't have permission.");
        }
	}

	@Override
	public String getUsage() {
		return "<command> <motd>";
	}
}
