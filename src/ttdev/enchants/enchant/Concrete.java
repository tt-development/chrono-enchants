package ttdev.enchants.enchant;

import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import ttdev.api.user.items.Item;
import ttdev.enchants.RandomNumberGen;
import ttdev.enchants.api.enchant.AggressiveEnchant;

public class Concrete extends AggressiveEnchant<LivingEntity, LivingEntity> {
	
	private final int duration = 20 * 3;

	public Concrete() {
		super("concrete", EnchantEnum.CONCRETE);
	}

	@Override
	public boolean hasEnchant(Item item) {
		return false;
	}

	@Override
	public void fire(LivingEntity entityOne, LivingEntity entityTwo, int level) {
		PotionEffectType slownessEffect = PotionEffectType.SLOW;
		if (!RandomNumberGen.generate(75)) {
			return;
		}
		switch (level) {
			case 1:
				entityTwo.addPotionEffect(new PotionEffect(slownessEffect, duration, 0, false, false));
				break;
			case 2:
				entityTwo.addPotionEffect(new PotionEffect(slownessEffect, duration, 1, false, false));
				break;
			case 3: 
				entityTwo.addPotionEffect(new PotionEffect(slownessEffect, duration, 2, false, false));
				break;
		}
	}

}
