package ttdev.enchants.enchant;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ttdev.enchants.RandomNumberGen;
import ttdev.enchants.api.enchant.AbstractEnchant;
import ttdev.enchants.api.enchant.EnchantTrigger;
import ttdev.enchants.api.event.PlayerHitEntityEvent;

public class Marshmallow extends AbstractEnchant<PlayerHitEntityEvent> {

    public Marshmallow() {
        super("marshmallow", EnchantTrigger.INFLICT_DAMAGE);
    }

    @Override
    public void trigger(ItemStack item, int level, Player player, PlayerHitEntityEvent event) {

        /* (80 - (level * 2))% to damage a player. */
        if (!RandomNumberGen.generate(80 - (level * 2))) {
            return;
        }

        /* Damage the entity according to the level. */
        event.getLivingEntity().damage((level != 0) ? (float) level / 2 : 1);
    }

}
