package ttdev.enchants.api.event.dispatch;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import ttdev.enchants.api.event.TableInteractEvent;

public final class InteractEventDispatcher implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        Action action = event.getAction();
        if (action != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        Block block = event.getClickedBlock();
        Material type = block.getType();
        if (type == Material.ENCHANTMENT_TABLE) {
            Bukkit.getPluginManager().callEvent(new TableInteractEvent(player, block.getLocation()));
            event.setCancelled(true);
        }
    }
}
