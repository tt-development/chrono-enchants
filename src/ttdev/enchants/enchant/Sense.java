package ttdev.enchants.enchant;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ttdev.enchants.api.enchant.EnchantTrigger;
import ttdev.enchants.api.enchant.GenericEnchant;

public class Sense extends GenericEnchant<Void> {

    public Sense() {
        super("sense", EnchantTrigger.NONE);
    }

    @Override
    public void trigger(ItemStack item, int level, Player player, Void v) {
        player.sendMessage("You have sense on your tool.");
    }

}
