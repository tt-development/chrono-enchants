package ttdev.enchants.enchant;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import ttdev.enchants.api.enchant.EnchantTrigger;
import ttdev.enchants.api.enchant.GenericEnchant;

public class Sense extends GenericEnchant<BlockBreakEvent> {

    public Sense() {
        super("sense", EnchantTrigger.BLOCK_BREAK);
        super.setDisplayName(ChatColor.WHITE + "Sense");
    }

    @Override
    public void trigger(ItemStack item, int level, Player player, BlockBreakEvent event) {

        int expToDrop = event.getExpToDrop();

        /* These values may need to be refined */
        event.setExpToDrop(expToDrop * (level + 1));
    }

}
