package ttdev.enchants.enchant;

import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import ttdev.enchants.api.enchant.PassiveEnchant;
import ttdev.enchants.handler.ConfigurationHandler;

public class Trifecta extends PassiveEnchant<LivingEntity> {

    public Trifecta() {
        super("trifecta");
    }

    @Override
    public boolean containsEnchant(ItemStack itemStack) {
        ItemMeta meta=itemStack.getItemMeta();
        return meta.getLore().contains(ConfigurationHandler.getName("Trifecta"));
    }

    @Override
    public void fire(LivingEntity entity,int level) {
        entity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 1, false, false));
    }

}
