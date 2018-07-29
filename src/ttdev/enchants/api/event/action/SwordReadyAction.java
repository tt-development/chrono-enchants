package ttdev.enchants.api.event.action;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import ttdev.enchants.ChronoEnchants;

public class SwordReadyAction implements EventAction<PlayerInteractEvent> {

    @Override
    public void handle(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        Action action = event.getAction();

        /* Code for handling readying of swords
        How it works:
        Player holds right-click for one second. Once that second
        is up their sword is considered ready.
         */
        if (action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR) {

            /* Don't need to make sure their holding a sword since
            only swords will have this enchantment.
             */

            new BukkitRunnable() {
                @Override
                public void run() {
                    if (player.isBlocking()) {
                        /* Consider the tool ready */
                        player.sendMessage(ChatColor.GREEN + "Sword readied.");

                        /* Wait until the player is done blocking
                        to launch them
                         */
                        while (player.isBlocking()) {
                            System.out.println("Player is still blocking.");
                        }

                        player.setVelocity(player.getEyeLocation().getDirection().multiply(10));
                        System.out.println("Launched player.");
                    }
                }
            }.runTaskLaterAsynchronously(ChronoEnchants.getInstance(), 20);
        }
    }
}
