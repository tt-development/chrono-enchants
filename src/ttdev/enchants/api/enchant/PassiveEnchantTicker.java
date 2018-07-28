package ttdev.enchants.api.enchant;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import ttdev.enchants.ChronoEnchants;

import java.util.Collection;

public class PassiveEnchantTicker {

    public void startTicking() {

        new BukkitRunnable() {

            @Override
            public void run() {

                Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();

                for (Player player : onlinePlayers) {
                    ItemStack[] armorContents = player.getInventory().getArmorContents();
                    for (ItemStack armorPiece : armorContents) {

                        if (armorPiece == null || !armorPiece.hasItemMeta()) {
                            continue;
                        }

                        EnchantInfo info = EnchantInfo.of(armorPiece, EnchantTrigger.NONE);
                        info.getEnchants().forEach((enchant, level) -> enchant.trigger(armorPiece, level, player, null));
                    }
                }

            }
        }.runTaskTimer(ChronoEnchants.getInstance(), 20, 20);

    }

}
