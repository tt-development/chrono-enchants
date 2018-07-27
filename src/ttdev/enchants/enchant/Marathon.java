package ttdev.enchants.enchant;

import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import ttdev.api.user.items.Item;
import ttdev.enchants.api.enchant.PassiveEnchant;

public class Marathon extends PassiveEnchant<LivingEntity> {

	private final int duration = 20 * 3;

    public Marathon() {
        super("marathon", EnchantEnum.MARATHON);
    }

    @Override
    public boolean hasEnchant(Item item) {
        return false;
    }

    @Override
    public void fire(LivingEntity entity, int level) {
        PotionEffectType speedEffect = PotionEffectType.SPEED;
        switch (level) {
            case 1:
                entity.addPotionEffect(new PotionEffect(speedEffect, duration, 0, false, false));
                break;
            case 2:
                entity.addPotionEffect(new PotionEffect(speedEffect, duration, 1, false, false));
                break;
        }
    }
}
