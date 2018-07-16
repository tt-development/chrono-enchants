package ttdev.enchants.api.enchant;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import ttdev.api.user.items.Item;
import ttdev.enchants.ChronoEnchants;
import ttdev.enchants.enchant.EnchantEnum;

import java.util.Collection;
import java.util.Set;

public class PassiveEnchantTicker {

    public void startTicking() {

        new BukkitRunnable() {

            EnchantExtractor extractor = new EnchantExtractor();

            @Override
            public void run() {

                Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();

                for (Player player : onlinePlayers) {
                    ItemStack[] armorContents = player.getInventory().getArmorContents();
                    for (ItemStack armorPiece : armorContents) {

                        if (armorPiece == null || !armorPiece.hasItemMeta()) {
                            continue;
                        }

                        Set<EnchantEnum> passiveEnchants = extractor.extractPassive(new Item(armorPiece));
                        passiveEnchants.forEach(enchant -> enchant.getEnchant(PassiveEnchant.class).fire(player, 1));
                    }
                }

            }

        }.runTaskTimer(ChronoEnchants.getInstance(), 20, 20);

    }

}
