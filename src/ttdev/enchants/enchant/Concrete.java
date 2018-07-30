package ttdev.enchants.enchant;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import ttdev.enchants.RandomNumberGen;
import ttdev.enchants.api.enchant.AbstractEnchant;
import ttdev.enchants.api.enchant.EnchantTrigger;

public class Concrete extends AbstractEnchant<LivingEntity> {

	public Concrete() {
		super("concrete", EnchantTrigger.INFLICT_DAMAGE);
		super.setDisplayName(ChatColor.GRAY+"Concrete");
		super.setDuration(20 * 3);
	}

	@Override
	public void trigger(ItemStack item, int level, Player player, LivingEntity entityTwo) {

		/* Generate the potioneffect. */
		PotionEffectType slownessEffect = PotionEffectType.SLOW;
		
		/* 25% chance to activate the enchant. */
		if (!RandomNumberGen.generate(75)) {
			return;
		}

		/* Give the entity the potioneffect. */
		entityTwo.addPotionEffect(new PotionEffect(slownessEffect, super.getDuration(), (level - 1), false, false));
	}

}
