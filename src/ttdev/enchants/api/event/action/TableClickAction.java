package ttdev.enchants.api.event.action;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import ttdev.enchants.InventoryManager;

public class TableClickAction implements EventAction<PlayerInteractEvent> {

    @Override
    public void handle(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        Action action = event.getAction();

        /* Code for handling right-clicking an enchant table */
        if (action == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            Material type = block.getType();
            if (type == Material.ENCHANTMENT_TABLE) {
                InventoryManager.openInventory(player);
                event.setCancelled(true);
            }
        }
    }
}
