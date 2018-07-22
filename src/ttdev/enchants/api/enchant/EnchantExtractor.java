package ttdev.enchants.api.enchant;

import org.bukkit.ChatColor;
import ttdev.api.APair;
import ttdev.api.user.items.Item;
import ttdev.enchants.enchant.EnchantEnum;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EnchantExtractor {

    public EnchantExtractor() {

    }

    public Set<APair<EnchantEnum,Integer>> extractPassive(Item item) {
        Set<APair<EnchantEnum,Integer>> enchantSet = extract(item);
        return enchantSet.stream().filter(pair->pair.getKey().isPassive()).collect(Collectors.toSet());
    }

    public Set<APair<EnchantEnum, Integer>> extract(Item item) {
        return item.getLore().stream()
                .map(String::toLowerCase)
                .map(this::collectEnchant)
                .collect(Collectors.toSet());
    }

    private APair<EnchantEnum, Integer> collectEnchant(String article) {
        final String strippedArticle= ChatColor.stripColor(article);
        Optional<EnchantEnum> enchantOptional = Arrays.stream(EnchantEnum.values())
                .filter(enchant -> strippedArticle.contains(enchant.getId()))
                .findAny();

        int level;
        if(enchantOptional.isPresent()){
            level=Integer.parseInt(strippedArticle.split(" ")[1]);
            return new APair<>(enchantOptional.get(),level);
        }

        return null;
    }
}
