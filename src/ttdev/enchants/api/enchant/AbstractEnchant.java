package ttdev.enchants.api.enchant;

import org.bukkit.inventory.ItemStack;

public abstract class AbstractEnchant {

    private String id;

    public AbstractEnchant(String id) {
        this.id = id;
    }

    public abstract boolean containsEnchant(ItemStack itemStack);

}
