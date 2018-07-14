package ttdev.enchants.handler;

import ttdev.enchants.ChronoEnchants;

import java.util.List;

public class ConfigurationHandler {

	public static int getChance(String enchant, int lvl) {
		String level = String.valueOf(lvl);
		if (!ChronoEnchants.getInstance().getConfig().contains("enchants." + enchant + ".lvl_" + level + "_chance")) {
			return 1;
		}
		return ChronoEnchants.getInstance().getConfig().getInt("enchants." + enchant + ".lvl_" + level + "_chance");
	}
	
	public static int getMaxLevel(String enchant, int lvl) {
		String level = String.valueOf(lvl);
		if (!ChronoEnchants.getInstance().getConfig().contains("enchants." + enchant + ".lvl_" + level + "_maxLevel")) {
			return 1;
		}
		return ChronoEnchants.getInstance().getConfig().getInt("enchants." + enchant + ".lvl_" + level + "_maxLevel");
	}
	
	public static int getBaseLevel(String enchant) {
		return 1;
	}
	
	public static String getName(String enchant) {
		if (!ChronoEnchants.getInstance().getConfig().contains("enchants." + enchant + ".name")) {
			return "Not set";
		}
		
		String name = ChronoEnchants.getInstance().getConfig().getString("enchants." + enchant + ".name");
		return name;
		//return ChatColor.translateAlternateColorCodes('&', ChronoEnchants.getInstance().getConfig().getString("enchants." + enchantment + "name"));
	}
	
	public static String getLore(String enchant) {
		if (!ChronoEnchants.getInstance().getConfig().contains("enchants." + enchant + ".lore")) {
			return "Not set";
		}
		
		String lore = ChronoEnchants.getInstance().getConfig().getString("enchants." + enchant + ".lore");
		return lore;
		//return ChatColor.translateAlternateColorCodes('&', ChronoEnchants.getInstance().getConfig().getString("enchants." + enchantment + "lore"));
	}
	
	public static List<String> getPossibleItems(String enchant) {
		if (!ChronoEnchants.getInstance().getConfig().contains("enchants." + enchant + ".item")) {
			return null;
		}
		return ChronoEnchants.getInstance().getConfig().getStringList("enchants." + enchant + ".item");
	}
	
	public static List<String> getEnchants() {
		return ChronoEnchants.getInstance().getConfig().getStringList("enabledEnchants");
	}
	
}
