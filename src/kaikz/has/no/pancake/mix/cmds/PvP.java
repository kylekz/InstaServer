package kaikz.has.no.pancake.mix.cmds;

import java.io.FileOutputStream;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import kaikz.has.no.pancake.mix.cmds.base.SubBase;
import kaikz.has.no.pancake.mix.main.InstaServer;

public class PvP extends SubBase {
	public PvP(InstaServer pl) {
		super(pl);
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		if (sender.hasPermission("instaserver.pvp")) {
			boolean enable = Boolean.parseBoolean(args[0]);
            plugin.getMinecraftServer().pvpMode = enable;
            plugin.getProps().put("pvp", String.valueOf(enable));
            try {
            	plugin.getProps().store(new FileOutputStream(plugin.getPropsPath()), null);
    			plugin.send(sender, plugin.info + "Set PvP restriction.");
    		} catch (IOException e) {
    			plugin.send(sender, plugin.error + "Failed to save properties.");
    		}
        } else {
        	plugin.send(sender, plugin.error + ChatColor.RED + "You don't have permission.");
        }
	}

	@Override
	public String getUsage() {
		return "<command> <true/false>";
	}
}
