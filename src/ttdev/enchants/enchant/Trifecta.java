package ttdev.enchants.enchant;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import ttdev.enchants.api.enchant.AbstractEnchant;
import ttdev.enchants.api.enchant.EnchantTrigger;

public class Trifecta extends AbstractEnchant<Void> {

    public Trifecta() {
        super("trifecta", EnchantTrigger.NONE);
        super.setDisplayName(ChatColor.AQUA+"Trifecta");
    }

    @Override
    public void trigger(ItemStack item, int level, Player player, Void v) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, super.getDuration(), 1, false, false));
    }

}
