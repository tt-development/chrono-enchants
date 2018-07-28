package ttdev.enchants.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import ttdev.enchants.api.enchant.EnchantInfo;
import ttdev.enchants.api.enchant.EnchantTrigger;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();
        ItemStack item = event.getPlayer().getItemInHand();

        /* Fire all passive enchantments for breaking blocks */
        EnchantInfo info = EnchantInfo.of(event.getPlayer().getItemInHand(), EnchantTrigger.BREAK_BLOCK);
        info.getEnchants().forEach((enchant, level) -> enchant.trigger(item, level, player, null));
    }
}
