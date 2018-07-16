package ttdev.enchants.api.enchant;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import ttdev.enchants.ChronoEnchants;
import ttdev.enchants.enchant.Enchant;

import java.util.Arrays;
import java.util.Collection;

public abstract class PassiveEnchant<EntityT> extends AbstractEnchant {

    private static Ticker ticker;

    public PassiveEnchant(String id) {
        super(id);
        ticker=new Ticker();
        if (!ticker.isStarted()) {
            System.out.println("Starting Ticker.");
            ticker.start();
        }
        System.out.println("Initialized new PassiveEnchant");
        System.out.println("Ticker: "+ticker.started);
    }

    @Override
    public abstract boolean containsEnchant(ItemStack itemStack);

    public abstract void fire(EntityT entity, int level);

    private static class Ticker {

        private boolean started = false;
        private final long tickRate = 20;

        boolean isStarted() {
            return started;
        }

        void start() {
            new BukkitRunnable() {
                @Override
                public void run() {
                    started = true;
                    Collection<? extends Player> playerList = Bukkit.getOnlinePlayers();
                    playerList.forEach(p -> {
                        ItemStack[] armor = p.getInventory().getArmorContents();
                        Arrays.stream(armor).forEach(is -> {
                            if (Enchant.TRIFECTA.containsEnchant(is)) {
                                Enchant.TRIFECTA.fire(p, 0);
                                System.out.println("Firing TRIFECTA for "+p.getName());
                            }
                        });
                    });
                    System.out.println("Timer run");
                }
            }.runTaskTimer(ChronoEnchants.getInstance(), tickRate, tickRate);
            System.out.println("Start method called in PassiveEnchant");
        }
    }
}
