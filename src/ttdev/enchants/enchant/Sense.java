package ttdev.enchants.enchant;

import org.bukkit.entity.LivingEntity;
import ttdev.api.user.items.Item;
import ttdev.enchants.api.enchant.PassiveEnchant;

public class Sense extends PassiveEnchant<LivingEntity> {
    public Sense() {
        super("sense",EnchantEnum.SENSE);
    }

    @Override
    public boolean hasEnchant(Item item) {
        return false;
    }

    @Override
    public void fire(LivingEntity entity, int level) {
        entity.sendMessage("You have sense on your tool.");
    }
}
