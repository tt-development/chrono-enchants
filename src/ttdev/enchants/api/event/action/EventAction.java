package ttdev.enchants.api.event.action;

import org.bukkit.event.Event;

public interface EventAction<EventType extends Event> {

    void handle(EventType event);

}
