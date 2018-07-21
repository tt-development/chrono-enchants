package ttdev.enchants.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import ttdev.api.APair;
import ttdev.api.user.items.Item;
import ttdev.enchants.api.enchant.EnchantExtractor;
import ttdev.enchants.api.enchant.PassiveEnchant;
import ttdev.enchants.enchant.EnchantEnum;

import java.util.Set;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        EnchantExtractor extractor=new EnchantExtractor();

        Set<APair<EnchantEnum, Integer>> enchantPairSet;
        enchantPairSet=extractor.extractPassive(new Item(event.getPlayer().getItemInHand()));
        enchantPairSet.forEach(pair->((PassiveEnchant<BlockBreakEvent>)pair.getKey().getEnchant()).fire(event,pair.getValue()));
    }
}
