package ttdev.enchants.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import ttdev.enchants.ChronoEnchants;
import ttdev.enchants.api.enchant.EnchantInfo;
import ttdev.enchants.api.enchant.EnchantTrigger;
import ttdev.enchants.api.event.PlayerHitEntityEvent;
import ttdev.enchants.api.user.User;

import java.util.UUID;

public final class PlayerHitEntityListener implements Listener {

    @EventHandler
    public void onPlayerHitEntity(PlayerHitEntityEvent event) {
        Player player = event.getPlayer();

        if (!event.isLivingEntity()) {
            return;
        }

        ItemStack itemInHand = player.getItemInHand();
        EnchantInfo info = EnchantInfo.of(itemInHand, EnchantTrigger.INFLICT_DAMAGE);

        /* Fire all enchantments for hitting entities */
        info.getEnchants().forEach((enchant, level) -> enchant.trigger(itemInHand, level, player, event));

        UUID PlayerUUID = player.getUniqueId();
        User user = ChronoEnchants.users.get(PlayerUUID);
        user.setCombatTime(System.currentTimeMillis());
    }
}
