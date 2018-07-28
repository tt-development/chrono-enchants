package ttdev.enchants.events;

import java.util.Set;
import java.util.UUID;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import ttdev.api.APair;
import ttdev.api.user.items.Item;
import ttdev.enchants.ChronoEnchants;
import ttdev.enchants.api.enchant.AggressiveEnchant;
import ttdev.enchants.api.enchant.EnchantExtractor;
import ttdev.enchants.api.event.PlayerHitEntityEvent;
import ttdev.enchants.api.user.User;
import ttdev.enchants.enchant.EnchantEnum;

public final class PlayerHitEntityListener implements Listener {

    @EventHandler
    public void onPlayerHitEntity(PlayerHitEntityEvent event) {
        Player player = event.getPlayer();

        if(!event.isLivingEntity()){
            return;
        }
        
        EnchantExtractor extractor = new EnchantExtractor();

        LivingEntity livingEntity = event.getLivingEntity();
        
        Set<APair<EnchantEnum, Integer>> enchantPairSet;
        enchantPairSet = extractor.extractAggressive(new Item(event.getPlayer().getItemInHand()));

        /* Fire all aggressive enchantments for hitting entities */
        enchantPairSet.forEach(pair->((AggressiveEnchant<LivingEntity, PlayerHitEntityEvent>)pair.getKey().getEnchant()).fire(livingEntity, event, pair.getValue()));

        UUID PlayerUUID = player.getUniqueId();
        User user = ChronoEnchants.users.get(PlayerUUID);
        user.setCombatTime(System.currentTimeMillis());
    }
}
