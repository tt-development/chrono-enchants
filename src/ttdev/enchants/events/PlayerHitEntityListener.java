package ttdev.enchants.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ttdev.enchants.api.event.PlayerHitEntityEvent;

public final class PlayerHitEntityListener implements Listener {

    @EventHandler
    public void onPlayerHitEntity(PlayerHitEntityEvent event) {
        Player player = event.getPlayer();
        Entity entity = event.getEntity();

        if(!event.isLivingEntity()){
            return;
        }

        LivingEntity livingEntity=event.getLivingEntity();

    }
}
