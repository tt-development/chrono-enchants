package ttdev.enchants.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import ttdev.enchants.InventoryManager;
import ttdev.enchants.api.enchant.EnchantInfo;
import ttdev.enchants.enchant.EnchantEnum;

public final class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        Action action = event.getAction();

        ItemStack itemInHand = player.getItemInHand();

        /* I will move this code somewhere else or do some other type of refactoring
         * since ideally this code shouldn't be in here. */
        EnchantInfo info = EnchantInfo.of(itemInHand, EnchantEnum.CARPE_DIEM);
        info.getEnchants().forEach((enchant, level) -> enchant.trigger(itemInHand, level, player, null));

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
