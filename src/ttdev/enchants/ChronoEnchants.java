package ttdev.enchants;

import org.bukkit.plugin.java.JavaPlugin;

public class ChronoEnchants extends JavaPlugin {

	private static ChronoEnchants singleton;
	
	public static ChronoEnchants getInstance() {
		return singleton;
	}
	
	@Override
	public void onEnable() {
		singleton = this;
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
