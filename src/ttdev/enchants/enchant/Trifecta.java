package ttdev.enchants.enchant;

import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import ttdev.api.user.items.Item;
import ttdev.enchants.api.enchant.PassiveEnchant;
import ttdev.enchants.handler.ConfigurationHandler;

public class Trifecta extends PassiveEnchant<LivingEntity> {

    public Trifecta() {
        super("trifecta", EnchantEnum.TRIFECTA);
    }

    @Override
    public boolean hasEnchant(Item item) {
        return item.getLore().contains(ConfigurationHandler.getName("Trifecta"));
    }

    @Override
    public void fire(LivingEntity entity,int level) {
        //TODO Modify to fit correctly with PassiveEnchantTicker tick time
        entity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 1, false, false));
    }

}
