package ttdev.enchants.enchant;

import ttdev.enchants.api.enchant.GenericEnchant;

import java.util.Arrays;

public enum EnchantEnum {

    TRIFECTA(new Trifecta()),
    MARATHON(new Marathon()),
    SENSE(new Sense()),
    SEAR(new Sear()),
    CONCRETE(new Concrete()),
    GREED(new Greed());

    private GenericEnchant<?> enchant;

    EnchantEnum(GenericEnchant enchant) {
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

}
