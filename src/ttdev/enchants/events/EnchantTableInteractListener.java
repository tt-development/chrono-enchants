package ttdev.enchants.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ttdev.enchants.InventoryManager;
import ttdev.enchants.api.event.TableInteractEvent;

public final class EnchantTableInteractListener implements Listener {

    @EventHandler
    public void onEnchantTableInteract(TableInteractEvent event) {
        Player player = event.getPlayer();
        InventoryManager.openInventory(player);
    }
}
