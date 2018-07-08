package ttdev.enchants.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import ttdev.api.API;
import ttdev.enchants.ChronoEnchants;

public class Attack implements Listener {

	static {
		new Attack();
	}
	
	private Attack() {
		API.getPluginManager().registerEvents(this, ChronoEnchants.getInstance());
	}
	
	@EventHandler
	public void onAttack(EntityDamageByEntityEvent e) {
		
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		
		//TODO add the enchants.
		
	}
	
	
}
