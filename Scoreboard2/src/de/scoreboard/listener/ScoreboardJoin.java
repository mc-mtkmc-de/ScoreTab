package de.scoreboard.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.scoreboard.main.Scoreboards;
import de.scoreboard.utils.OnlinePlayer;

public class ScoreboardJoin implements Listener {
	
	public static String prefix;
	
	private final long TABLIST_DELAY = 1*20;
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		prefix(event.getPlayer());
		OnlinePlayer.playersOnline();
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Scoreboards.getPlugin(), new Runnable() {
			
			@Override
			public void run() {
				for (Player player : Bukkit.getOnlinePlayers()) {
					prefix(player);
					OnlinePlayer.playersOnline();
				}
				
			}

		}, 0, TABLIST_DELAY);
		
	}
	
	public void prefix(Player p) {
		
		String team = "";
		
		if(p.hasPermission("tab.admin")) {
			team = "000Admin||||";
		} else if(p.hasPermission("tab.dev")) {
			team = "002Dev||||";
		} else if(p.hasPermission("tab.mbuilder")) {
			team = "003MBuilder||||";
		} else if(p.hasPermission("tab.builder")) {
			team = "004Builder||||";
		} else if(p.hasPermission("tab.azubi")) {
			team = "005Azubi||||";
		} else if(p.hasPermission("tab.mod")) {
			team = "006Mod||||";
		} else if(p.hasPermission("tab.sup")) {
			team = "007Sup||||";
		} else if(p.hasPermission("tab.freund")) {
			team = "008Freund||||";
		} else if(p.hasPermission("tab.yt+")) {
			team = "009YT||||";
		} else if(p.hasPermission("tab.champ")) {
			team = "0010Champ||||";
		}  else if(p.hasPermission("tab.drache")) {
			team = "0011Drache||||";
		} else if(p.hasPermission("tab.titan")) {
			team = "0012Titan||||";
		} else if(p.hasPermission("tab.yt")) {
			team = "0013You||||";
		} else if(p.hasPermission("tab.legende")) {
			team = "0014Legende||||";
		} else if(p.hasPermission("tab.ultra")) {
			team = "0015Ultra||||";
		} else if(p.hasPermission("tab.premium")) {
			team = "0016Premium||||";
		} else {
			team = "0017Spieler||||";
		}
		
		Scoreboards.board.getTeam(team).addPlayer(p);
		p.setDisplayName(Scoreboards.board.getTeam(team).getPrefix() + p.getName());
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			all.setScoreboard(Scoreboards.board);
		
		}
		
	}

}

