package ttdev.enchants.enchant;

import ttdev.enchants.api.enchant.AbstractEnchant;

import java.util.Arrays;

public enum EnchantEnum {

    TRIFECTA(new Trifecta(), "trifecta", true, false),
    MARATHON(new Marathon(), "marathon", true, false),
    SENSE(new Sense(), "sense", true, false),
    SEAR(new Sear(), "sear", true, false),
	CONCRETE(new Concrete(), "concrete", false, true),
	GREED(new Greed(), "greed", false, true);

    private AbstractEnchant enchant;
    private String id;
    private boolean passive;
    private boolean aggressive;

    EnchantEnum(AbstractEnchant enchant, String id, boolean passive, boolean aggressive) {
        this.enchant = enchant;
        this.id = id;
        this.passive = passive;
    }

    public <EnchantT extends AbstractEnchant> EnchantT getEnchant(Class<EnchantT> clazz) {
        return clazz.cast(enchant);
    }

    public static EnchantEnum getEnchant(String enchant) {
        return Arrays.stream(values())
                .filter(e -> e.id.equalsIgnoreCase(enchant))
                .findAny()
                .orElse(null);
    }

    public AbstractEnchant getEnchant() {
        return enchant;
    }

    public String getId() {
        return id;
    }

    public boolean isPassive() {
        return passive;
    }
    
    public boolean isAggressive() {
    	return aggressive;
    }

}
