package de.scoreboard.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.scoreboard.main.Scoreboards;

public class ScoreboardJoin implements Listener {
	
	private final long TABLIST_DELAY = 1*20;
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		setprefix(event.getPlayer());
		Bukkit.getOnlinePlayers().size();
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Scoreboards.getPlugin(), new Runnable() {
			
			@Override
			public void run() {
				for (Player player : Bukkit.getOnlinePlayers()) {
					setprefix(player);
					setRang(player);
					Bukkit.getOnlinePlayers().size();
					
				}
				
			}

		}, 20, TABLIST_DELAY);
		
	}
	
	public void setprefix(Player p) {
		
		String team = "";
		
		if(p.hasPermission("tab.admin")) {
			team = "00000Admin::";
		} else if(p.hasPermission("tab.dev")) {
			team = "00002Dev::";
		} else if(p.hasPermission("tab.mbuilder")) {
			team = "00003MBuilder::";
		} else if(p.hasPermission("tab.builder")) {
			team = "00004Builder::";
		} else if(p.hasPermission("tab.azubi")) {
			team = "00005Azubi::";
		} else if(p.hasPermission("tab.mod")) {
			team = "00006Mod::";
		} else if(p.hasPermission("tab.sup")) {
			team = "00007Sup::";
		} else if(p.hasPermission("tab.freund")) {
			team = "00008Freund::";
		} else if(p.hasPermission("tab.yt+")) {
			team = "00009YT::";
		} else if(p.hasPermission("tab.champ")) {
			team = "000010Champ::";
		}  else if(p.hasPermission("tab.drache")) {
			team = "000011Drache::";
		} else if(p.hasPermission("tab.titan")) {
			team = "000012Titan::";
		} else if(p.hasPermission("tab.yt")) {
			team = "000013You::";
		} else if(p.hasPermission("tab.legende")) {
			team = "000014Legende::";
		} else if(p.hasPermission("tab.ultra")) {
			team = "000015Ultra::";
		} else if(p.hasPermission("tab.premium")) {
			team = "000016Premium::";
		} else {
			team = "000017Spieler::";
		}
		
		Scoreboards.board.getTeam(team).addPlayer(p);
		p.setDisplayName(Scoreboards.board.getTeam(team).getPrefix() + p.getName());
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			all.setScoreboard(Scoreboards.board);
		
		}
		
	}
	
	public static String setRang(Player p) {
		
		p.getDisplayName();
		
		return p.getDisplayName();
	}

}

