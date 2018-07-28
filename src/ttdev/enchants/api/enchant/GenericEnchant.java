package ttdev.enchants.api.enchant;

import com.google.common.collect.Sets;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public abstract class GenericEnchant<ObjectType> {

    private String name;
    private String fancyName;
    private Set<EnchantTrigger> triggers;

    /* Some enchantments may want to use a duration */
    private int duration = 0;

    public GenericEnchant(String name, EnchantTrigger... triggers) {
        this.name = name;
        this.fancyName = name;
        this.triggers = Sets.newHashSet(triggers);
    }

    /**
     * @param item       Item containing the enchantment.
     * @param player     Entity wearing or holding the <code>item</code>.
     * @param objectType Entity or block interacted with.
     */
    public abstract void trigger(ItemStack item, int level, Player player, ObjectType objectType);

    public String getName() {
        return name;
    }

    public String getFancyName() {
        return fancyName;
    }

    public void setFancyName(String fancyName) {
        this.fancyName = fancyName;
    }

    public Set<EnchantTrigger> getTriggers() {
        return triggers;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
