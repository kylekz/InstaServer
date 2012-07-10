package kaikz.has.no.pancake.mix.cmds.base;

import kaikz.has.no.pancake.mix.main.InstaServer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CmdInsta extends InstaCommandBase {
	public CmdInsta(InstaServer pl) {
		super(pl);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLine, String[] args) {
		if (cmd.getName().equalsIgnoreCase("insta")) {
			if (args.length > 0) {
				String s = "";
		        for (String sa : args) {
		        	s += sa + " ";
		        }
				
				try {
					s = s.trim();
		            int i = s.indexOf(' ');
		            String s1;
		            String as[];
		            if (i < 0) {
		                s1 = s;
		                as = new String[0];
		            } else {
		                s1 = s.substring(0, i).toLowerCase();
		                as = s.substring(i).trim().split(" ");
		            }
		            if (plugin.commands.containsKey(s1)) {
		                SubBase base = (SubBase)plugin.commands.get(s1);
		                if (base == null) {
		                	plugin.send(sender, plugin.error + "Command class not found!");
		                    return true;
		                } else {
		                	if (args.length == 1) {
		                		plugin.send(sender, plugin.info + "Usage: " + base.getUsage().replace("<command>", "/" + cmd.getName() + " " + s1));
		                		return true;
		                	} else {
		                		base.run(sender, as);
			                	return true;
		                	}
		                }
		            } else {
		            	plugin.send(sender, plugin.error + "No such command!");
		            	return true;
		            }
		        } catch (Exception e) {
		        	e.printStackTrace();
		        	plugin.send(sender, plugin.error + e.getMessage().toString());
		            return true;
		        }
			}
		}
		return false;
	}

}
