package ttdev.enchants.handler;

import java.util.List;

import net.md_5.bungee.api.ChatColor;
import ttdev.enchants.ChronoEnchants;

public class ConfigurationHandler {

	public static int getChance(String enchant) {
		if (!ChronoEnchants.getInstance().getConfig().contains("enchants." + enchant + ".chance")) {
			return 10;
		}
		return ChronoEnchants.getInstance().getConfig().getInt("enchants." + enchant + ".chance");
	}
	
	public static int getMaxLevel(String enchant) {
		if (!ChronoEnchants.getInstance().getConfig().contains("enchants." + enchant + ".maxLevel")) {
			return 1;
		}
		return ChronoEnchants.getInstance().getConfig().getInt("enchants." + enchant + ".maxLevel");
	}
	
	public static int getBaseLevel(String enchant) {
		return 1;
	}
	
	public static String getName(String enchant) {
		if (!ChronoEnchants.getInstance().getConfig().contains("enchants." + enchant + ".name")) {
			return "Not set";
		}
		return ChatColor.translateAlternateColorCodes('&', ChronoEnchants.getInstance().getConfig().getString("enchants." + enchant + ".name"));
	}
	
	public static String getLore(String enchant) {
		if (!ChronoEnchants.getInstance().getConfig().contains("enchants." + enchant + ".lore")) {
			return "Not set";
		}
		return ChatColor.translateAlternateColorCodes('&', ChronoEnchants.getInstance().getConfig().getString("enchants." + enchant + "lore"));
	}
	
	public static List<String> getPossibleItems(String enchant) {
		if (!ChronoEnchants.getInstance().getConfig().contains("enchants." + enchant + ".item")) {
			return null;
		}
		return ChronoEnchants.getInstance().getConfig().getStringList("enchant." + enchant + ".item");
	}
	
	public static List<String> getEnchants() {
		return ChronoEnchants.getInstance().getConfig().getStringList("enchants");
	}
	
}
