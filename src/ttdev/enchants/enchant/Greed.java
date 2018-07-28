package ttdev.enchants.enchant;

import java.util.ArrayList;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import ttdev.api.user.items.Item;
import ttdev.enchants.api.enchant.AggressiveEnchant;

public class Greed extends AggressiveEnchant<LivingEntity, EntityDeathEvent> {

	public Greed() {
		super("greed", EnchantEnum.GREED);
	}

	@Override
	public boolean hasEnchant(Item item) {
		return false;
	}

	@Override
	public void fire(LivingEntity entity, EntityDeathEvent event, int level) {
		
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
