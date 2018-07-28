package ttdev.enchants.api.enchant;

import ttdev.api.user.items.Item;
import ttdev.enchants.enchant.EnchantEnum;

public abstract class AbstractEnchant {

    private String id;
    private EnchantEnum type;

    public AbstractEnchant(String id, EnchantEnum type) {
        this.id = id;
        this.type = type;
    }

    public boolean isSame(EnchantEnum type) {
        return this.type == type;
    } 

    public abstract boolean hasEnchant(Item item);

    public String getId() {
        return id;
    }

    public EnchantEnum getType() {
        return type;
    }

}
