package de.scoreboard.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.scoreboard.listener.ScoreboardJoin;

public class Scoreboards extends JavaPlugin {
	
	public static Scoreboards plugin;
	
	public void onEnable() {
		plugin = this;
		
		Bukkit.getPluginManager().registerEvents(new ScoreboardJoin(), this);
		
		

	}


	public static Scoreboards getPlugin() {
		return plugin;
	}
	
}