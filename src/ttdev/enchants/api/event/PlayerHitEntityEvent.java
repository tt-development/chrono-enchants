package ttdev.enchants.api.event;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerHitEntityEvent extends Event {

    private static HandlerList handlerList = new HandlerList();

    private Player player;
    private Entity entity;

    public PlayerHitEntityEvent(Player player, Entity entity) {
        this.player = player;
        this.entity = entity;
    }

    public Player getPlayer() {
        return player;
    }

    public Entity getEntity() {
        return entity;
    }

    public LivingEntity getLivingEntity() {
        return (LivingEntity) entity;
    }

    public boolean isLivingEntity() {
        return entity instanceof LivingEntity;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
