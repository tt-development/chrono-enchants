package ttdev.enchants.enchant;

import ttdev.enchants.api.enchant.AbstractEnchant;

public enum EnchantEnum {

    TRIFECTA(new Trifecta(), "trifecta", true);

    private AbstractEnchant enchant;
    private String id;
    private boolean passive;

    EnchantEnum(AbstractEnchant enchant, String id, boolean passive) {
        this.enchant = enchant;
        this.id = id;
        this.passive = passive;
    }

    public <EnchantT extends AbstractEnchant> EnchantT getEnchant(Class<EnchantT> clazz) {
        return clazz.cast(enchant);
    }

    public String getId() {
        return id;
    }

    public boolean isPassive() {
        return passive;
    }

}
