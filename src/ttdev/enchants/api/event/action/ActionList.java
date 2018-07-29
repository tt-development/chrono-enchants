package ttdev.enchants.api.event.action;

import java.util.ArrayList;
import java.util.List;

public class ActionList {

    private static List<EventAction> eventActions = new ArrayList<>();

    static void add(EventAction action) {
        eventActions.add(action);
    }

    public static EventAction getAction(Class<? extends EventAction> actionClass) {
        return eventActions.stream()
                .filter(action -> action.getClass().isInstance(actionClass))
                .findAny()
                .orElse(null);
    }
}
