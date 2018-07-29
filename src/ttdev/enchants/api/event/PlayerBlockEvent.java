package ttdev.enchants.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerBlockEvent extends Event {

    private static HandlerList handlerList=new HandlerList();

    private Player player;

    public PlayerBlockEvent(Player player){
        this.player=player;
    }

    public Player getPlayer(){
        return player;
    }

    public static HandlerList getHandlerList(){
        return handlerList;
    }

    public HandlerList getHandlers(){
        return handlerList;
    }
}
