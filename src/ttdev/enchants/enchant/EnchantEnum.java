package ttdev.enchants.enchant;

import ttdev.enchants.api.enchant.AbstractEnchant;

import java.util.Arrays;

public enum EnchantEnum {

    TRIFECTA(new Trifecta()),
    MARATHON(new Marathon()),
    SENSE(new Sense()),
    SEAR(new Sear()),
    CONCRETE(new Concrete()),
    GREED(new Greed()),
    CARPE_DIEM(new CarpeDiem());

    private AbstractEnchant<?> enchant;

    EnchantEnum(AbstractEnchant enchant) {
        this.enchant = enchant;
    }

    public AbstractEnchant<?> getEnchant() {
        return enchant;
    }

    public static AbstractEnchant<?> getEnchant(String name) {
        return Arrays.stream(values())
                .filter(enumVal -> enumVal.getEnchant().getName().equalsIgnoreCase(name))
                .findAny()
                .map(EnchantEnum::getEnchant)
                .orElse(null);
    }

}
