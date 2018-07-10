package ttdev.enchants.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import ttdev.api.user.items.Item;

public class EnchantmentHandler {
	
	public static void enchant(Item item, int level, Player player) {
		
		Material itemType = item.getMaterial();
		
		//All posible enchants.
		ArrayList<String> enchants = new ArrayList<String>(); 
		
		for (String enchant : ConfigurationHandler.getEnchants()) {
			if (ConfigurationHandler.getPossibleItems(enchant).contains(itemType.toString())) {
				if (!enchants.contains("enchant") & ConfigurationHandler.getChance(enchant, level) != 0 & ConfigurationHandler.getMaxLevel(enchant, level) != 0) {
					enchants.add(enchant);
				}
			}
		}
		
		for (String enchant : ConfigurationHandler.getEnchants()) {
			for (String lore : item.getLore()) {
				if (lore.contains(ConfigurationHandler.getLore(enchant))) {
					System.out.println(enchant);
					enchants.remove(enchant);
				}
			}
		}
		
		if (enchants.size() == 0) {
			return;
		}
		
		//Max chance.
		int maxChance = 0;
		for (int i=0; i < enchants.size(); i++) {
			maxChance = maxChance + ConfigurationHandler.getChance(enchants.get(i), level);
		}
		
		//Pick the enchant.
		Random randomNumberGenerator = new Random();
		int random = randomNumberGenerator.nextInt(maxChance) + 1;
		
		HashMap<String, Integer> enchantsChanceMin = new HashMap<String, Integer>();
		HashMap<String, Integer> enchantsChanceMax = new HashMap<String, Integer>();
		int enchantsChanceSize = 0;
		
		for (int i=0; i < enchants.size(); i++) {
			if (enchantsChanceSize == 0) {
				enchantsChanceMin.put(enchants.get(i), 1);
				enchantsChanceMax.put(enchants.get(i), (enchantsChanceSize + ConfigurationHandler.getChance(enchants.get(i), level)));
				enchantsChanceSize = enchantsChanceSize + ConfigurationHandler.getChance(enchants.get(i), level);
			} else {
				enchantsChanceMin.put(enchants.get(i), (enchantsChanceSize + 1));
				enchantsChanceMax.put(enchants.get(i), (enchantsChanceSize + ConfigurationHandler.getChance(enchants.get(i), level)));
				enchantsChanceSize = enchantsChanceSize + ConfigurationHandler.getChance(enchants.get(i), level);
			}
		}
		
		String enchantName = null;
		
		for (int i=0; i < enchants.size(); i++) {
			int low = enchantsChanceMin.get(enchants.get(i));
			int max = enchantsChanceMax.get(enchants.get(i));
			
			for (int a=low; a < (max + 1); a++) {
				if (random == a) {
					enchantName = enchants.get(i);
					break;
				}
			}
		}
		
		//Pick the level of the enchant.
		int enchantmentLevel = 1;
		
		int low = ConfigurationHandler.getBaseLevel(enchantName);
		int max = ConfigurationHandler.getMaxLevel(enchantName, level);
		
		enchantmentLevel = randomNumberGenerator.nextInt(max) + low;
		
		ItemStack tmp = item.getItemStack();
		item = addEnchant(item, enchantName, enchantmentLevel);
		
		player.getInventory().remove(tmp);
		player.getInventory().addItem(item.getItemStack());
		
	}

	private static Item addEnchant(Item item, String enchant, int level) {
		if (isDefaultEnchantment(enchant)) {
			item.addEnchant(Enchantment.getByName(enchant), level);
		} else {
			String lore = ChatColor.translateAlternateColorCodes('&', ConfigurationHandler.getLore(enchant) + " &r" + level);
			item.addLore(lore);
		}
		 
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
