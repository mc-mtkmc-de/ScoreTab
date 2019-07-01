package de.scoreboard.utils;

import org.bukkit.Bukkit;

public class OnlinePlayer {

	public static int playersOnline;
	
	public static void playersOnline() {
		Bukkit.getOnlinePlayers().size();
	}

	public int getPlayersOnline() {
		return playersOnline;
	}

	public static void setPlayersOnline(int playersOnline) {
		OnlinePlayer.playersOnline = playersOnline;
	}
	
}
