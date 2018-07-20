package ttdev.enchants.enchant;

import ttdev.enchants.api.enchant.AbstractEnchant;

import java.util.Arrays;

public enum EnchantEnum {

    TRIFECTA(new Trifecta(), "trifecta", true),
    MARATHON(new Marathon(), "marathon", true);

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

    public static EnchantEnum getEnchant(String enchant){
        return Arrays.stream(values())
                .filter(e ->e.id.equalsIgnoreCase(enchant))
                .findAny()
                .orElse(null);
    }

    public AbstractEnchant getEnchant(){
        return enchant;
    }

    public String getId() {
        return id;
    }

    public boolean isPassive() {
        return passive;
    }

}
