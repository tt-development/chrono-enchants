package ttdev.enchants.handler;

import java.util.List;

import ttdev.enchants.ChronoEnchants;

public class ConfigurationHandler {

	public static void getChance(String enchant) {
		ChronoEnchants.getInstance().getConfig().getString("enchants." + enchant + ".chance");
	}
	
	public void getMaxLevel(String enchant) {
		ChronoEnchants.getInstance().getConfig().getString("enchants." + enchant + ".maxLevel");
	}
	
	public static int getBaseLevel(String enchant) {
		return 1;
	}
	
	public static String getName(String enchant) {
		return ChronoEnchants.getInstance().getConfig().getString("enchants." + enchant + ".name");
	}
	
	public static List<String> getLore(String enchant) {
		return ChronoEnchants.getInstance().getConfig().getStringList("enchants." + enchant + "lore");
	}
	
}
