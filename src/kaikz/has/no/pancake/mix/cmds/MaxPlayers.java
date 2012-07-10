package kaikz.has.no.pancake.mix.cmds;

import java.io.FileOutputStream;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import kaikz.has.no.pancake.mix.cmds.base.SubBase;
import kaikz.has.no.pancake.mix.main.InstaServer;

public class MaxPlayers extends SubBase {
	public MaxPlayers(InstaServer pl) {
		super(pl);
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		if (sender.hasPermission("instaserver.maxplayers")) {
			int players = Integer.parseInt(args[0]);
            plugin.getMinecraftServer().serverConfigurationManager.maxPlayers = players;
            plugin.getProps().put("max-players", String.valueOf(players));
            try {
            	plugin.getProps().store(new FileOutputStream(plugin.getPropsPath()), null);
    			plugin.send(sender, plugin.info + "Set max players.");
    		} catch (IOException e) {
    			plugin.send(sender, plugin.error + "Failed to save properties.");
    		}
        } else {
        	plugin.send(sender, plugin.error + ChatColor.RED + "You don't have permission.");
        }
	}

	@Override
	public String getUsage() {
		return "<command> <players>";
	}
}
