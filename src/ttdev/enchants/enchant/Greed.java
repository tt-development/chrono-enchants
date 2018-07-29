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
		
		ArrayList<ItemStack> drops = new ArrayList<>();
		
		for (int i=0; i < event.getDrops().size(); i++) {
			ItemStack tempItemStack = event.getDrops().get(i);
			tempItemStack.setAmount(tempItemStack.getAmount() + level);
			drops.add(tempItemStack);
		}
		
		event.getDrops().clear();
		event.getDrops().addAll(drops);
		
	}

}
