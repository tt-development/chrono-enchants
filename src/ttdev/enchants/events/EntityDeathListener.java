package ttdev.enchants.events;

import java.util.Set;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import ttdev.api.APair;
import ttdev.api.user.items.Item;
import ttdev.enchants.api.enchant.AggressiveEnchant;
import ttdev.enchants.api.enchant.EnchantExtractor;
import ttdev.enchants.enchant.EnchantEnum;

public class EntityDeathListener implements Listener {

	public void onEntityDeath(EntityDeathEvent event) {
		
		if (!(event.getEntity() instanceof Monster)) {
			return;
		}
		
		if (event.getEntity().getKiller() != null) {
			return;
		}
		
		Player killer = event.getEntity().getKiller();
		
        EnchantExtractor extractor = new EnchantExtractor();

        LivingEntity livingEntity = event.getEntity();
        
        Set<APair<EnchantEnum, Integer>> enchantPairSet;
        enchantPairSet = extractor.extractAggressive(new Item(killer.getItemInHand()));

        /* Fire all aggressive enchantments for hitting entities */
        enchantPairSet.forEach(pair->((AggressiveEnchant<LivingEntity, EntityDeathEvent>)pair.getKey().getEnchant()).fire(livingEntity, event, pair.getValue()));

		
	}
	
}
