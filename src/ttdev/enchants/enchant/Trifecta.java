package ttdev.enchants.enchant;

import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import ttdev.enchants.api.enchant.PassiveEnchant;

public class Trifecta extends PassiveEnchant<LivingEntity> {

    public Trifecta() {
        super("trifecta");
    }

    @Override
    public boolean containsEnchant(ItemStack itemStack) {
        return false;
    }

    @Override
    public void fire(LivingEntity entity) {

    }

}
