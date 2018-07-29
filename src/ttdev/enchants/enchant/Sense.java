package ttdev.enchants.enchant;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import ttdev.enchants.api.enchant.AbstractEnchant;
import ttdev.enchants.api.enchant.EnchantTrigger;

public class Sense extends AbstractEnchant<BlockBreakEvent> {

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
