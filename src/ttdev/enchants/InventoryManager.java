package ttdev.enchants;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import ttdev.api.bukkit.Manager;
import ttdev.api.user.inventory.AInventory;
import ttdev.api.user.inventory.events.inventoryclick.InventoryClick;
import ttdev.api.user.inventory.events.inventoryclick.InventoryListener;
import ttdev.api.user.items.Item;
import ttdev.enchants.handler.EnchantmentHandler;

public class InventoryManager implements InventoryListener {
	
	static {
		new InventoryManager();
	}
	
	private InventoryManager() {
		Manager.registerEvent(this);
	}

	public static void openInventory(Player player) {
		
		AInventory inventory = new AInventory("&bChrono &cEnchants", 4);
		
		//TODO Config support.
		Item level5 = new Item(Material.COAL);
		level5.addLore("LORE");
		level5.setName("NAME");
		
		Item level15 = new Item(Material.IRON_ORE);
		level15.addLore("LORE");
		level15.setName("NAME");
		
		Item level30 = new Item(Material.GOLD_ORE);
		level30.addLore("LORE");
		level30.setName("NAME");
		
		Item level45 = new Item(Material.DIAMOND_ORE);
		level45.addLore("LORE");
		level45.setName("NAME");
		
		Item level60 = new Item(Material.EMERALD_ORE);
		level60.addLore("LORE");
		level60.setName("NAME");
		
		Item filler = new Item(Material.STAINED_GLASS_PANE);
		filler.setName("ChronoEnchants");
		
		for (int i=0; i < 27; i++) {
			if (i != 13) {
				inventory.setItem(filler, i);
			}
		}
		inventory.setItem(filler, 28);
		inventory.setItem(filler, 30);
		inventory.setItem(filler, 32);
		inventory.setItem(filler, 34);
		
		inventory.setItem(level5, 27);
		inventory.setItem(level15, 29);
		inventory.setItem(level30, 31);
		inventory.setItem(level45, 33);
		inventory.setItem(level60, 35);
		
		inventory.openInventory(player);
	}

	@Override
	public void InventoryClickEvent(InventoryClick event) {
		
		if (event.getInventory().compareNameTo("&bChrono &cEnchants")) {
			
			if (event.getSlot() == 13) {
				return;
			}
			
			event.cancelAction();
			
			Item item = new Item(event.getInventory().getInventory().getItem(13));
			
			Player player = event.getWhoClicked();
			
			if (event.getSlot() == 27) {
				EnchantmentHandler.enchant(item, 5, player);
				event.getWhoClicked().closeInventory();
				return;
			}
			if (event.getSlot() == 29) {
				EnchantmentHandler.enchant(item, 15, player);
				event.getWhoClicked().closeInventory();
				return;
			}
			if (event.getSlot() == 31) {
				EnchantmentHandler.enchant(item, 30, player);
				event.getWhoClicked().closeInventory();
				return;
			}
			if (event.getSlot() == 33) {
				EnchantmentHandler.enchant(item, 45, player);
				event.getWhoClicked().closeInventory();
				return;
			}
			if (event.getSlot() == 35) {
				EnchantmentHandler.enchant(item, 60, player);
				event.getWhoClicked().closeInventory();
				return;
			}
		}
		
	}
	
}
