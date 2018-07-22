package ttdev.enchants.enchant;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import ttdev.api.user.items.Item;
import ttdev.enchants.api.enchant.PassiveEnchant;

public class Sear extends PassiveEnchant<BlockBreakEvent> {

    public Sear() {
        super("sear", EnchantEnum.SEAR);
    }

    @Override
    public boolean hasEnchant(Item item) {
        return false;
    }

    @Override
    public void fire(BlockBreakEvent event, int level) {
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
