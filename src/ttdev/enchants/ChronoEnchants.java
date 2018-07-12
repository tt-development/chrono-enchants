package ttdev.enchants;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import ttdev.enchants.api.event.InteractEventDispatcher;
import ttdev.enchants.events.EnchantTableInteract;

public class ChronoEnchants extends JavaPlugin {

	private static ChronoEnchants singleton;
	
	public static ChronoEnchants getInstance() {
		return singleton;
	}
	
	@Override
	public void onEnable() {
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
				
		singleton = this;

		PluginManager manager = getServer().getPluginManager();
		manager.registerEvents(new InteractEventDispatcher(), this);
		manager.registerEvents(new EnchantTableInteract(), this);

		getLogger().info(getName()+" enabled.");
	}
	
	@Override
	public void onDisable() {
		this.saveConfig();
		getLogger().info(getName()+" disabled.");
	}
	
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }
        
        Player player = (Player) sender;
        
        if (label.equalsIgnoreCase("cenchant")) {
        	if (args.length == 1) {
            	if (args[0].equalsIgnoreCase("reload")) {
            		reloadConfig();
            		player.sendMessage(ChatColor.GREEN + "Reloaded the config.");
            		return true;
            	}
        	}
        	InventoryManager.openInventory(player);
        }
        
        return true;
        
    }
	
}
