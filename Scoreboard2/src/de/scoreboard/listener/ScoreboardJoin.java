package de.scoreboard.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.scoreboard.main.Scoreboards;
import de.scoreboard.utils.ScoreTab;

public class ScoreboardJoin implements Listener {
	
	private final long TABLIST_DELAY = 1*20;
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		ScoreTab.scoreboard(event.getPlayer());
		setprefix(event.getPlayer());
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Scoreboards.getPlugin(), new Runnable() {
			
			@Override
			public void run() {
				for (Player player : Bukkit.getOnlinePlayers()) {
					setprefix(player);
					updateScoreboard(player);
					
				}
				
			}

		}, 20, TABLIST_DELAY);
		
	}
	
	
	
	public void setprefix(Player p) {
		
		String team = "";
		
		if(p.hasPermission("tab.admin")) {
			team = "000Admin:::";
		} else if(p.hasPermission("tab.dev")) {
			team = "002Dev:::";
		} else if(p.hasPermission("tab.mbuilder")) {
			team = "003MBuilder:::";
		} else if(p.hasPermission("tab.builder")) {
			team = "004Builder:::";
		} else if(p.hasPermission("tab.azubi")) {
			team = "005Azubi:::";
		} else if(p.hasPermission("tab.mod")) {
			team = "006Mod:::";
		} else if(p.hasPermission("tab.sup")) {
			team = "007Sup:::";
		} else if(p.hasPermission("tab.freund")) {
			team = "008Freund:::";
		} else if(p.hasPermission("tab.yt+")) {
			team = "009YT:::";
		} else if(p.hasPermission("tab.champ")) {
			team = "010Champ:::";
		}  else if(p.hasPermission("tab.drache")) {
			team = "011Drache:::";
		} else if(p.hasPermission("tab.titan")) {
			team = "012Titan:::";
		} else if(p.hasPermission("tab.yt")) {
			team = "013You:::";
		} else if(p.hasPermission("tab.legende")) {
			team = "014Legende:::";
		} else if(p.hasPermission("tab.ultra")) {
			team = "015Ultra:::";
		} else if(p.hasPermission("tab.premium")) {
			team = "016Premium:::";
		} else {
			team = "017Spieler:::";
		}
		
		ScoreTab.board.getTeam(team).addPlayer(p);
		p.setDisplayName(ScoreTab.board.getTeam(team).getPrefix() + p.getName());
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			all.setScoreboard(ScoreTab.board);
		
		}
		
	}
	
	public static void updateScoreboard(Player p) {
		
		ScoreTab.obj.getScore("§1§l" + p.getDisplayName()).setScore(3);
		ScoreTab.obj.getScore("§d§l" + Bukkit.getOnlinePlayers().size() + "§b§l/§c§l" + Bukkit.getMaxPlayers()).setScore(1);
		
	}

}

