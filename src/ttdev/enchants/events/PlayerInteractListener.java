package ttdev.enchants.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import ttdev.enchants.api.event.action.ActionList;
import ttdev.enchants.api.event.action.SwordReadyAction;
import ttdev.enchants.api.event.action.TableClickAction;

public final class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        ActionList.getAction(SwordReadyAction.class).handle(event);
        ActionList.getAction(TableClickAction.class).handle(event);
    }
}
