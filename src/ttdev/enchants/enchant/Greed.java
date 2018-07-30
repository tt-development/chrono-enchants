package ttdev.enchants.enchant;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import ttdev.enchants.api.enchant.AbstractEnchant;
import ttdev.enchants.api.enchant.EnchantTrigger;

import java.util.ArrayList;

public class Greed extends AbstractEnchant<EntityDeathEvent> {

	public Greed() {
		super("greed", EnchantTrigger.INFLICT_DAMAGE);
	}

	@Override
	public void trigger(ItemStack item, int level, Player player, EntityDeathEvent event) {
		
		/* Get the list of drops. */
		ArrayList<ItemStack> drops = new ArrayList<>();
		
		/* Add extra items to a new list. */
		for (int i=0; i < event.getDrops().size(); i++) {
			ItemStack tempItemStack = event.getDrops().get(i);
			tempItemStack.setAmount(tempItemStack.getAmount() + level);
			drops.add(tempItemStack);
		}
		
		/* Replace the old list with the new list. */
		event.getDrops().clear();
		event.getDrops().addAll(drops);
		
	}

}
