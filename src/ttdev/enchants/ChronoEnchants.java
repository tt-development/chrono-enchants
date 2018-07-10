package ttdev.enchants;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

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
