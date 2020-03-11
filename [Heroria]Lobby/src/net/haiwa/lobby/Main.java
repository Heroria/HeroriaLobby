package net.haiwa.lobby;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.haiwa.lobby.cmd.CmdPa;
import net.haiwa.lobby.listeners.ListenersManager;

public class Main extends JavaPlugin{
	
	public static Main INSTANCE;
	
	@Override
	public void onEnable() {
		INSTANCE = this;
		
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new ListenersManager(), this);
		getCommand("pa").setExecutor(new CmdPa());
		
	}
	
	@Override
	public void onDisable() {
		
	}
}
