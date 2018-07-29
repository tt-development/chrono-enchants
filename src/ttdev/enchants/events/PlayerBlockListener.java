package ttdev.enchants.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import ttdev.enchants.api.event.PlayerBlockEvent;
import ttdev.enchants.enchant.EnchantEnum;

public class PlayerBlockListener implements Listener {

    @EventHandler
    public void onPlayerBlock(PlayerBlockEvent event) {

        Player player = event.getPlayer();
        ItemStack itemInHand = player.getItemInHand();

        /* For debugging purposes */
        EnchantEnum.CARPE_DIEM.getEnchant().trigger(itemInHand, 1, player, null);

        System.out.println("Triggered Carpe Diem");

//        EnchantInfo info = EnchantInfo.of(itemInHand, EnchantTrigger.NONE);
//        info.getEnchants().forEach((enchant, level) -> enchant.trigger(itemInHand, level, player, null));
    }
}
