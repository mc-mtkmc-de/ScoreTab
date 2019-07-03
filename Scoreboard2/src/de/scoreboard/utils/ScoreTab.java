package de.scoreboard.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreTab {
	
	public static Scoreboard board;
	public static Objective obj;
	
	public static void scoreboard(Player p) {
		
		
		
		board = Bukkit.getScoreboardManager().getMainScoreboard();
		obj = board.registerNewObjective("das ist volll", "behindert!!!");
		
		Team Admin = board.registerNewTeam("000Admin::::");
		Team Dev = board.registerNewTeam("002Dev::::");
		Team MBuilder = board.registerNewTeam("003MBuilder::::");
	 	Team Builder = board.registerNewTeam("004Builder::::");
		Team Azubi = board.registerNewTeam("005Azubi::::");
		Team Mod = board.registerNewTeam("006Mod::::");
		Team Sup = board.registerNewTeam("007Sup::::");
		Team Freund = board.registerNewTeam("008Freund::::");
		Team YT = board.registerNewTeam("009YT::::");
		Team Champ = board.registerNewTeam("010Champ::::");
		Team Drache = board.registerNewTeam("011Drache::::");
		Team Titan = board.registerNewTeam("012Titan::::");
		Team You = board.registerNewTeam("013You::::");
		Team Legende = board.registerNewTeam("014Legende::::");
		Team Ultra = board.registerNewTeam("015Ultra::::");
		Team Premium = board.registerNewTeam("016Premium::::");
		Team Spieler = board.registerNewTeam("017Spieler::::");
		
		Admin.setPrefix("§a[Admin]");
		Dev.setPrefix("§b[Dev]");
		MBuilder.setPrefix("§2[MBuilder]");
		Builder.setPrefix("§a[Builder]");
		Azubi.setPrefix("§d[Azubi]");
		Mod.setPrefix("§3[Mod]");
		Sup.setPrefix("§2[Sup]");
		Freund.setPrefix("§c[Freund]");
		YT.setPrefix("§5[YT§4+§5]");
		Champ.setPrefix("§e[Champ]");
		Drache.setPrefix("§4[Drache]");
		Titan.setPrefix("§9[Titan]");
		You.setPrefix("§5[YT]");
		Legende.setPrefix("§c[Legende]");
		Ultra.setPrefix("§b[Ultra]");
		Premium.setPrefix("§6[Premium]");
		Spieler.setPrefix("§7[Spieler]");
		
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("§6§lEnderGamesMC.de"); 
		obj.getScore("§6§lRang").setScore(5);
		obj.getScore("§c§l").setScore(4);
		obj.getScore("§1§l" + p.getDisplayName()).setScore(3);
		obj.getScore("§6§lOnline:").setScore(2);
		obj.getScore("§d§l" + Bukkit.getOnlinePlayers().size() + "§b§l/§c§l" + Bukkit.getMaxPlayers()).setScore(1);
		
	}

}
