package ttdev.enchants;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import ttdev.api.user.items.Item;
import ttdev.enchants.handler.EnchantmentHandler;

public class ChronoEnchants extends JavaPlugin {

	private static ChronoEnchants singleton;
	
	public static ChronoEnchants getInstance() {
		return singleton;
	}
	
	@Override
	public void onEnable() {
		
		this.getConfig();
		this.getConfig().options().copyDefaults(true);
		
		this.saveConfig();
		
		System.out.println(this.getConfig().getString("enchants.Goggles.lore"));
		
		singleton = this;
	}
	
	@Override
	public void onDisable() {
		this.saveConfig();
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }
        
        Player player = (Player) sender;
        
        if (label.equalsIgnoreCase("enchant")) {
        	
        	Item item = new Item(player.getItemInHand());
        	
        	if (item.getMaterial().equals(Material.DIAMOND_HELMET)) {
        		
        		item = EnchantmentHandler.addEnchant(item, "Goggles", 1);
        		player.getInventory().addItem(item.getItemStack());
        		
        	}
        	
        }
        
        return true;
        
    }
	
}
