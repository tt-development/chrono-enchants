package ttdev.enchants.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.enchantments.Enchantment;

import ttdev.api.user.items.Item;

public class EnchantmentHandler {
	
	public static Item enchant(Item item) {
		
		ArrayList<String> enchants = new ArrayList<String>();
		
		for (String enchant : ConfigurationHandler.getEnchants()) {
			for (String possibleItem : ConfigurationHandler.getPossibleItems(enchant)) {
				if (item.getMaterial().toString().equalsIgnoreCase(possibleItem)) {
					enchants.add(enchant);
				}
			}
		}
		
		int maxChance = 0;
		for (int i=0; i < enchants.size(); i++) {
			maxChance = maxChance + ConfigurationHandler.getChance(enchants.get(i));
		}
		
		Random randomNumberGenerator = new Random();
		int random = randomNumberGenerator.nextInt(maxChance) + 1;
		
		HashMap<String, Integer> enchantsChanceMin = new HashMap<String, Integer>();
		HashMap<String, Integer> enchantsChanceMax = new HashMap<String, Integer>();
		int enchantsChanceSize = 0;
		
		for (int i=0; i < enchants.size(); i++) {
			if (enchantsChanceSize == 0) {
				enchantsChanceMin.put(enchants.get(i), 0);
				enchantsChanceMax.put(enchants.get(i), (enchantsChanceSize + ConfigurationHandler.getChance(enchants.get(i))));
				enchantsChanceSize = enchantsChanceSize + ConfigurationHandler.getChance(enchants.get(i));
			} else {
				enchantsChanceMin.put(enchants.get(i), (enchantsChanceSize));
				enchantsChanceMax.put(enchants.get(i), (enchantsChanceSize + ConfigurationHandler.getChance(enchants.get(i))));
				enchantsChanceSize = enchantsChanceSize + ConfigurationHandler.getChance(enchants.get(i));
			}
		}
		
		//TODO
		//add level.
		
		for (int i=0; i < enchants.size(); i++) {
			int low = enchantsChanceMin.get(enchants.get(i));
			int max = enchantsChanceMax.get(enchants.get(i));
			
			for (int a=low; a < (max + 1); a++) {
				if (random == a) {
					addEnchant(item, enchants.get(i), 1);
					break;
				}
			}
		}
		
		return item;
	}

	public static Item addEnchant(Item item, String enchant, int level) {
		
		if (isDefaultEnchantment(enchant)) {
			item.addEnchant(Enchantment.getByName(enchant), level);
		} else {
			item.setName(ConfigurationHandler.getName(enchant + " " + level));
			item.addLore(ConfigurationHandler.getLore(enchant));
		}
		 
		return item;
	}
	
	public static Item addEnchant(Item item, Enchantment enchant, int level) {
		
		item.addEnchant(enchant, level);
		 
		return item;
	}
	
	private static boolean isDefaultEnchantment(String enchant) {
		Enchantment tmp = Enchantment.getByName(enchant);
		if (tmp == null) {
			return false;
		}
		return true;
	}
	
}
