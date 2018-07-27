package ttdev.enchants.events;

import java.util.UUID;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ttdev.enchants.ChronoEnchants;
import ttdev.enchants.api.user.User;

public class PlayerServerJoinListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		UUID PlayerUUID = e.getPlayer().getUniqueId();
		ChronoEnchants.users.put(PlayerUUID, new User(e.getPlayer()));
	}
	
}
