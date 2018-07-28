package ttdev.enchants.api.enchant;

import com.google.common.collect.Sets;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ttdev.enchants.enchant.EnchantEnum;

import java.util.*;

public class EnchantInfo {

    private final Map<GenericEnchant<?>, Integer> enchants = new HashMap<>();

    private EnchantInfo(ItemStack item, Filter filter) {

        ItemMeta meta = item.getItemMeta();
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

                if (filter != null) {
                    Set<EnchantTrigger> triggers = filter.getTriggers();
                    if (!enchant.getTriggers().containsAll(triggers)) {
                        return;
                    }
                }

                if (str.contains(enchant.getFancyName())) {
                    String[] split = str.split(" ");
                    int level = Integer.parseInt(split[1].trim());
                    enchants.put(enchant, level);
                }
            });

        });
    }

    private static class Filter {

        private Set<EnchantTrigger> triggers;

        public Filter(EnchantTrigger... triggers) {
            this.triggers = Sets.newHashSet(triggers);
        }

        public Set<EnchantTrigger> getTriggers() {
            return triggers;
        }
    }

    public static EnchantInfo of(ItemStack item) {
        return new EnchantInfo(item, null);
    }

    /* Filter for a certain trigger */
    public static EnchantInfo of(ItemStack item, EnchantTrigger... triggers) {
        return new EnchantInfo(item, new Filter(triggers));
    }

    public Map<GenericEnchant<?>, Integer> getEnchants() {
        return enchants;
    }

}
