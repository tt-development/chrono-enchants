package ttdev.enchants.events;

import java.util.UUID;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import ttdev.enchants.ChronoEnchants;

public class PlayerServerLeaveListener implements Listener {

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		UUID PlayerUUID = e.getPlayer().getUniqueId();
		ChronoEnchants.users.remove(PlayerUUID);
	}
	
}
