package ttdev.enchants.api.event.action;

import java.util.ArrayList;
import java.util.List;

public class ActionList {

    private static List<EventAction> eventActions = new ArrayList<>();

    static {
        eventActions.add(new SwordReadyAction());
        eventActions.add(new TableClickAction());
    }

    public static EventAction getAction(Class<? extends EventAction> actionClass) {
        return eventActions.stream()
                .filter(action -> action.getClass().equals(actionClass))
                .findAny()
                .orElse(null);
    }
}
