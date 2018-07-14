package ttdev.enchants.api.enchant;

import org.bukkit.inventory.ItemStack;

public abstract class AgressiveEnchant<EntityOneT, EntityTwoT> extends AbstractEnchant {

    public AgressiveEnchant(String id) {
        super(id);
    }

    @Override
    public abstract boolean containsEnchant(ItemStack itemStack);

    public abstract void fire(EntityOneT entityOne, EntityTwoT entityTwo);
}
