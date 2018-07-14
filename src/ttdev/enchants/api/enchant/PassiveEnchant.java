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

    public PassiveEnchant(String id) {
        super(id);
    }

    @Override
    public abstract boolean containsEnchant(ItemStack itemStack);

    public abstract void fire(EntityT entity);

    private static class Ticker {

        private final long tickRate = 20;

        //TODO Refactor class
        void startTicking() {
            new BukkitRunnable() {
                @Override
                public void run() {
                    Collection<? extends Player> playerList = Bukkit.getOnlinePlayers();
                    playerList.forEach(p -> {
                        ItemStack[] armor = p.getInventory().getArmorContents();
                        Arrays.stream(armor).forEach(is -> {
                            if (Enchant.TRIFECTA.containsEnchant(is)) {
                                Enchant.TRIFECTA.fire(p);
                            }
                        });
                    });
                }
            }.runTaskTimer(ChronoEnchants.getInstance(), tickRate, tickRate);
        }
    }
}
