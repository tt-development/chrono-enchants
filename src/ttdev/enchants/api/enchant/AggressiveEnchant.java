package ttdev.enchants.api.enchant;

import ttdev.api.user.items.Item;
import ttdev.enchants.enchant.EnchantEnum;

public abstract class AggressiveEnchant<EntityOneT, EntityTwoT> extends AbstractEnchant {

    public AggressiveEnchant(String id, EnchantEnum type) {
        super(id, type);
    }

    @Override
    public abstract boolean hasEnchant(Item item);

    public abstract void fire(EntityOneT entityOne, EntityTwoT entityTwo, int level);
}
