package ttdev.enchants.api.enchant;

import ttdev.api.user.items.Item;
import ttdev.enchants.enchant.EnchantEnum;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class EnchantExtractor {

    EnchantExtractor() {

    }

    public Set<EnchantEnum> extractPassive(Item item) {
        Set<EnchantEnum> enchantSet = extract(item);
        return enchantSet.stream().filter(EnchantEnum::isPassive).collect(Collectors.toSet());
    }

    public Set<EnchantEnum> extract(Item item) {
        return item.getLore().stream()
                .map(String::toLowerCase)
                .map(this::collectEnchant)
                .collect(Collectors.toSet());
    }

    private EnchantEnum collectEnchant(String article) {
        return Arrays.stream(EnchantEnum.values())
                .filter(enchant -> article.contains(enchant.getId()))
                .findFirst().orElse(null);
    }
}
