package kaikz.has.no.pancake.mix.cmds.base;

import kaikz.has.no.pancake.mix.main.InstaServer;

import org.bukkit.command.CommandSender;

public abstract class SubBase {
	protected InstaServer plugin;
	
	public SubBase(InstaServer pl) {
		plugin = pl;
	}
	
	public abstract void run(CommandSender sender, String[] args);
	public abstract String getUsage();
}
