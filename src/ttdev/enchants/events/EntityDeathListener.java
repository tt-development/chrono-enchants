package ttdev.enchants.events;

import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import ttdev.enchants.api.enchant.EnchantInfo;
import ttdev.enchants.api.enchant.EnchantTrigger;

public class EntityDeathListener implements Listener {

	public void onEntityDeath(EntityDeathEvent event) {

		if (!(event.getEntity() instanceof Monster)) {
			return;
		}

		if (event.getEntity().getKiller() != null) {
			return;
		}

		Player killer = event.getEntity().getKiller();

		ItemStack itemInHand = killer.getItemInHand();
		EnchantInfo info = EnchantInfo.of(itemInHand, EnchantTrigger.INFLICT_DAMAGE);

		/* Fire all enchantments for hitting entities */
		info.getEnchants().forEach((enchant, level) -> enchant.trigger(itemInHand, level, killer, event));


	}

}
