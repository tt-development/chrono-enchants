package ttdev.enchants.api.event.dispatch;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import ttdev.enchants.api.event.PlayerHitEntityEvent;

public final class EntityHitEntityEventDispatcher implements Listener {

    @EventHandler
    public void onEntityHitEntity(EntityDamageByEntityEvent event) {

        Entity playerEntity = event.getDamager();
        if (!(playerEntity instanceof Player)) {
            return;
        }

        Player player = (Player) playerEntity;
        Entity entity = event.getEntity();

        Bukkit.getServer().getPluginManager().callEvent(new PlayerHitEntityEvent(player, entity));
    }
}
