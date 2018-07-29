package ttdev.enchants.api.enchant;

import com.google.common.collect.Sets;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ttdev.enchants.enchant.EnchantEnum;

import java.util.*;
import java.util.stream.Collectors;

public class EnchantInfo {

    private final Map<GenericEnchant, Integer> enchants = new HashMap<>();

    private EnchantInfo(ItemStack item, Filter filter) {

        ItemMeta meta = item.getItemMeta();
        if (meta != null && !meta.hasLore()) {
            return;
        }

        List<String> lore = meta.getLore();

        /* Go through each line of lore on the item
        and see if the lore contains one of the values
        from EnchantEnum, if it does then add the enchant
        to the hash map. If a filter is present then this
        will also consider the triggers of the enchant
        values from EnchantEnum
         */
        lore.forEach(str -> {

            Arrays.stream(EnchantEnum.values()).forEach(entry -> {

                GenericEnchant<?> enchant = entry.getEnchant();

                if (!str.contains(enchant.getDisplayName())) {
                    return;
                }

                String[] split = str.split(" ");
                int level = Integer.parseInt(split[1]);
                enchants.put(enchant, level);
            });

        });

        /* Remove all enchantments that don't match those in the filter */
        if (!filter.enchants.isEmpty()) {
            /* Check to see if the number of enchantments and type of enchantments are exactly like the filters
             * and if this isn't the case clear the map of enchantments */
            if (enchants.keySet().containsAll(filter.enchants) && enchants.keySet().size() == filter.enchants.size()) ;
            else {
                enchants.clear();
            }
        }

        /* Remove all enchantments that don't contain specified triggers
         * Either filter.triggers or filter.enchants should have elements. Not both. */
        if (!filter.triggers.isEmpty()) {
            enchants.keySet().stream()
                    .filter(enchant -> !enchant.getTriggers().containsAll(filter.triggers))
                    .forEach(enchants::remove);
        }


    }

    private static class Filter {

        private Set<EnchantTrigger> triggers;
        private Set<GenericEnchant> enchants;

        private Filter(EnchantTrigger... triggers) {
            this.triggers = Sets.newHashSet(triggers);
        }

        private Filter(EnchantEnum... enchants) {
            this.enchants =
                    Arrays.stream(enchants).map(EnchantEnum::getEnchant).collect(Collectors.toSet());
        }

        private Set<EnchantTrigger> getTriggers() {
            return triggers;
        }

        private Set<GenericEnchant> getEnchants() {
            return enchants;
        }
    }

    public static EnchantInfo of(ItemStack item) {
        return new EnchantInfo(item, null);
    }

    /* Filter for a certain trigger */
    public static EnchantInfo of(ItemStack item, EnchantTrigger... triggers) {
        return new EnchantInfo(item, new Filter(triggers));
    }

    /* Filter for a certain enchantment */
    public static EnchantInfo of(ItemStack item, EnchantEnum... enchants) {
        return new EnchantInfo(item, new Filter(enchants));
    }

    public Map<GenericEnchant, Integer> getEnchants() {
        return enchants;
    }

}
