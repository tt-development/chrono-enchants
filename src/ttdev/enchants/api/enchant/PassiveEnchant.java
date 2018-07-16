package ttdev.enchants.api.enchant;

import ttdev.api.user.items.Item;
import ttdev.enchants.enchant.EnchantEnum;

public abstract class PassiveEnchant<EntityT> extends AbstractEnchant {

    public PassiveEnchant(String id, EnchantEnum type) {
        super(id, type);
    }

    @Override
    public abstract boolean hasEnchant(Item item);

    public abstract void fire(EntityT entity, int level);

}
