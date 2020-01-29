package pl.gr4ss.core.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	
	public static String fixColor(String text) {
		return ChatColor.translateAlternateColorCodes('&', text.replace(">>", "»").replace("<<", "«").replace("<3", "❤"));
	}
	public static List<String> fixColor(final List<String> asList) {
		final List<String> list = new ArrayList<String>();
		for (final String text : asList){
			list.add(fixColor(text));
		}
		return list;
	}
	public static void sendMessage(final Player p, final String text){
		p.sendMessage(fixColor(text));
	}
	public static boolean sendMessage(final CommandSender sender, final String text){
		sender.sendMessage(fixColor(text));
		return false;
	}
}
