package ttdev.enchants.enchant;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import ttdev.enchants.api.enchant.AbstractEnchant;
import ttdev.enchants.api.enchant.EnchantTrigger;

public class Marathon extends AbstractEnchant<Void> {


    public Marathon() {
        super("marathon", EnchantTrigger.NONE);
        super.setDisplayName(ChatColor.YELLOW+"Marathon");
        super.setDuration(20 * 6);
    }

    @Override
    public void trigger(ItemStack itemStack, int level, Player player, Void v) {

        PotionEffectType speedEffect = PotionEffectType.SPEED;

        switch (level) {
            case 1:
                player.addPotionEffect(new PotionEffect(speedEffect, super.getDuration(), 0, false, false));
                break;
            case 2:
                player.addPotionEffect(new PotionEffect(speedEffect, super.getDuration(), 1, false, false));
                break;
        }
    }
}
