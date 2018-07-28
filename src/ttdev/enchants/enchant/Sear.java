package ttdev.enchants.enchant;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import ttdev.enchants.api.enchant.EnchantTrigger;
import ttdev.enchants.api.enchant.GenericEnchant;

public class Sear extends GenericEnchant<BlockBreakEvent> {

    public Sear() {
        super("sear", EnchantTrigger.BLOCK_BREAK);
        super.setDisplayName(ChatColor.GOLD+"Sear");
    }

    @Override
    public void trigger(ItemStack item, int level, Player player, BlockBreakEvent event) {
        Block block = event.getBlock();
        Material material = block.getType();
        ItemStack returnStack;
        if (material == Material.IRON_ORE) {
            returnStack = new ItemStack(Material.IRON_INGOT);
        } else if (material == Material.GOLD_ORE) {
            returnStack = new ItemStack(Material.GOLD_INGOT);
        } else {
            return;
        }
        event.setCancelled(true);
        block.setType(Material.AIR);
        block.getWorld().dropItemNaturally(block.getLocation(),returnStack);
    }
}
