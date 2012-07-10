package kaikz.has.no.pancake.mix.cmds;

import java.io.FileOutputStream;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import kaikz.has.no.pancake.mix.cmds.base.SubBase;
import kaikz.has.no.pancake.mix.main.InstaServer;

public class Online extends SubBase {
	public Online(InstaServer pl) {
		super(pl);
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		if (sender.hasPermission("instaserver.online")) {
			boolean enable = Boolean.parseBoolean(args[0]);
            plugin.getMinecraftServer().onlineMode = enable;
            plugin.getProps().put("online-mode", String.valueOf(enable));
            try {
            	plugin.getProps().store(new FileOutputStream(plugin.getPropsPath()), null);
    			plugin.send(sender, plugin.info + "Set online mode.");
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
