package ttdev.enchants.enchant;

import ttdev.enchants.api.enchant.GenericEnchant;

import java.util.Arrays;

public enum EnchantEnum {

<<<<<<< HEAD
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
=======
    TRIFECTA(new Trifecta()),
    MARATHON(new Marathon()),
    SENSE(new Sense()),
    SEAR(new Sear()),
    CONCRETE(new Concrete());

    private GenericEnchant<?> enchant;

    EnchantEnum(GenericEnchant enchant) {
>>>>>>> 4fa76c2eb937feca076bd237b2df3f42d3ffdb20
        this.enchant = enchant;
    }

    public GenericEnchant<?> getEnchant() {
        return enchant;
    }

    public static GenericEnchant<?> getEnchant(String name) {
        return Arrays.stream(values())
                .filter(enumVal -> enumVal.getEnchant().getName().equalsIgnoreCase(name))
                .findAny()
                .map(EnchantEnum::getEnchant)
                .orElse(null);
    }

<<<<<<< HEAD
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

=======
>>>>>>> 4fa76c2eb937feca076bd237b2df3f42d3ffdb20
}
