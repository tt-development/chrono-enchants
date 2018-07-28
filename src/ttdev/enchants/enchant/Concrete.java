package ttdev.enchants.enchant;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import ttdev.enchants.RandomNumberGen;
import ttdev.enchants.api.enchant.EnchantTrigger;
import ttdev.enchants.api.enchant.GenericEnchant;

public class Concrete extends GenericEnchant<LivingEntity> {
	
	public Concrete() {
		super("concrete", EnchantTrigger.INFLICT_DAMAGE);
		super.setDuration(20 * 3);
	}

	@Override
	public void trigger(ItemStack item, int level, Player player, LivingEntity entityTwo) {

		PotionEffectType slownessEffect = PotionEffectType.SLOW;
		if (!RandomNumberGen.generate(75)) {
			return;
		}
		switch (level) {
			case 1:
				entityTwo.addPotionEffect(new PotionEffect(slownessEffect, super.getDuration(), 0, false, false));
				break;
			case 2:
				entityTwo.addPotionEffect(new PotionEffect(slownessEffect, super.getDuration(), 1, false, false));
				break;
			case 3: 
				entityTwo.addPotionEffect(new PotionEffect(slownessEffect, super.getDuration(), 2, false, false));
				break;
		}
	}

}
