package ttdev.enchants;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import ttdev.enchants.api.enchant.AbstractEnchant;
import ttdev.enchants.api.enchant.EnchantTrigger;
import ttdev.enchants.api.enchant.PassiveEnchantTicker;
import ttdev.enchants.api.event.dispatch.EntityHitEntityEventDispatcher;
import ttdev.enchants.api.user.User;
import ttdev.enchants.enchant.EnchantEnum;
import ttdev.enchants.events.BlockBreakListener;
import ttdev.enchants.events.PlayerHitEntityListener;
import ttdev.enchants.events.PlayerInteractListener;
import ttdev.enchants.events.PlayerServerJoinListener;

import java.util.HashMap;
import java.util.UUID;

public class ChronoEnchants extends JavaPlugin {

    private static ChronoEnchants singleton;

    public static HashMap<UUID, User> users = new HashMap<>();

    public static ChronoEnchants getInstance() {
        return singleton;
    }

    @Override
    public void onEnable() {

        this.getConfig().options().copyDefaults(true);
        this.saveConfig();

        singleton = this;

        PluginManager manager = getServer().getPluginManager();
        /* register api listeners */
        manager.registerEvents(new PlayerInteractListener(), this);
        manager.registerEvents(new EntityHitEntityEventDispatcher(), this);
        /* register implementation listeners */
        manager.registerEvents(new PlayerHitEntityListener(), this);
        manager.registerEvents(new BlockBreakListener(), this);
        manager.registerEvents(new PlayerServerJoinListener(), this);



        new PassiveEnchantTicker().startTicking();

        getLogger().info(getName() + " enabled.");
    }

    @Override
    public void onDisable() {
        this.saveConfig();
        getLogger().info(getName() + " disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        /* Used for testing enchantments without enchanting an item */
        if (label.equalsIgnoreCase("ctestpassive")) {
            if (args.length < 2) {
                player.sendMessage(ChatColor.RED + "Incorrect syntax.");
                return true;
            }
            AbstractEnchant<?> enchant = EnchantEnum.getEnchant(args[0]);
            if (enchant == null) {
                player.sendMessage(ChatColor.RED + "Couldn't find enchant with name " + args[0] + ".");
                return true;
            }
            if (!enchant.getTriggers().contains(EnchantTrigger.NONE)) {
                player.sendMessage(ChatColor.RED + "You can only test passive enchants.");
                return true;
            }
            enchant.trigger(player.getItemInHand(), Integer.parseInt(args[1]), player, null);
            player.sendMessage("Testing enchant " + enchant.getDisplayName() + ".");
        }

        if (label.equalsIgnoreCase("cenchant")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    reloadConfig();
                    player.sendMessage(ChatColor.GREEN + "Reloaded the config.");
                    return true;
                }
            }
            InventoryManager.openInventory(player);
        }

        return true;

    }
}
