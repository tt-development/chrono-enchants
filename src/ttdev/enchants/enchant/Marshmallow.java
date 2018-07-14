package ttdev.enchants.enchant;

import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import ttdev.enchants.api.enchant.AgressiveEnchant;

public class Marshmallow extends AgressiveEnchant<LivingEntity, LivingEntity> {

    public Marshmallow() {
        super("marshmallow");
    }

    @Override
    public boolean containsEnchant(ItemStack itemStack) {
        return false;
    }

    @Override
    public void fire(LivingEntity entityOne, LivingEntity entityTwo) {
    }
}
