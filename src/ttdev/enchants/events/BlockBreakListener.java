package ttdev.enchants.events;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import ttdev.api.APair;
import ttdev.api.user.items.Item;
import ttdev.enchants.api.enchant.EnchantExtractor;
import ttdev.enchants.api.enchant.PassiveEnchant;
import ttdev.enchants.enchant.EnchantEnum;
import ttdev.enchants.enchant.Sense;

import java.util.Set;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getItemInHand();
        EnchantExtractor extractor = new EnchantExtractor();
        Set<APair<EnchantEnum,Integer>> enchantSet = extractor.extractPassive(new Item(item));
        enchantSet.stream()
                .map(APair::getKey)
                .filter(enchant -> enchant.getEnchant(Sense.class) != null)
                .findAny()
                .ifPresent(enchant -> ((PassiveEnchant<LivingEntity>) enchant.getEnchant()).fire(player, 1));
    }
}
