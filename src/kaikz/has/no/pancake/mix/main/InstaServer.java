package kaikz.has.no.pancake.mix.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import kaikz.has.no.pancake.mix.cmds.*;
import kaikz.has.no.pancake.mix.cmds.base.CmdInsta;
import net.minecraft.server.MinecraftServer;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class InstaServer extends JavaPlugin {
	private String propsPath = "";
	private Properties props = new Properties();
	private MinecraftServer server = null;
	public HashMap commands = new HashMap();
	public String error = ChatColor.RED + "[Insta]: " + ChatColor.GRAY;
	public String info = ChatColor.GREEN + "[Insta]: " + ChatColor.GRAY;
	
	@Override
	public void onEnable() {
		server = ((CraftServer)getServer()).getServer();
		propsPath = server.getPropertiesFile();
		
		getCommand("insta").setExecutor(new CmdInsta(this));
		
		commands.clear();
		commands.put("motd", new MOTD(this));
		commands.put("flight", new Flight(this));
		commands.put("online", new Online(this));
		commands.put("pvp", new PvP(this));
		commands.put("animals", new Animals(this));
		commands.put("npcs", new NPCs(this));
		commands.put("maxplayers", new MaxPlayers(this));
		
		try {
			props.load(new FileInputStream(propsPath));
		} catch (IOException e) {}
	}
	
	public void send(CommandSender sender, String message) {
		if (sender instanceof Player) {
			sender.sendMessage(message);
		} else {
			sender.sendMessage(ChatColor.stripColor(message));
		}
	}
	
	public MinecraftServer getMinecraftServer() {
		return server;
	}
	
	public Properties getProps() {
		return props;
	}
	
	public String getPropsPath() {
		return propsPath;
	}
	
	public void setMaxPlayers(int players) {
		getMinecraftServer().serverConfigurationManager.maxPlayers = players;
	}
	
	public void setMotd(String motd) {
		getMinecraftServer().motd = motd;
	}
	
	public void setOnlineMode(boolean enable) {
		getMinecraftServer().onlineMode = enable;
	}
	
	public void setPvp(boolean enable) {
		getMinecraftServer().pvpMode = enable;
	}
	
	public void setNpcs(boolean enable) {
		getMinecraftServer().spawnNPCs = enable;
	}
	
	public void setAnimals(boolean enable) {
		getMinecraftServer().spawnAnimals = enable;
	}
	
	public void setFlight(boolean enable) {
		getMinecraftServer().allowFlight = enable;
	}
}
