package kaikz.has.no.pancake.mix.cmds.base;

import java.util.logging.Logger;

import kaikz.has.no.pancake.mix.main.InstaServer;

import org.bukkit.command.CommandExecutor;

public abstract class InstaCommandBase implements CommandExecutor {
    protected InstaServer plugin;
    protected static Logger log;

    public InstaCommandBase(InstaServer pl) {
        this.plugin = pl;
        this.log = pl.getLogger();
    }
}
