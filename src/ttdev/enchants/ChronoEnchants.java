package ttdev.enchants;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import ttdev.enchants.api.enchant.PassiveEnchant;
import ttdev.enchants.api.enchant.PassiveEnchantTicker;
import ttdev.enchants.api.event.dispatch.EntityHitEntityEventDispatcher;
import ttdev.enchants.api.event.dispatch.InteractEventDispatcher;
import ttdev.enchants.api.user.User;
import ttdev.enchants.enchant.EnchantEnum;
import ttdev.enchants.events.BlockBreakListener;
import ttdev.enchants.events.EnchantTableInteractListener;
import ttdev.enchants.events.PlayerHitEntityListener;
import ttdev.enchants.events.PlayerServerJoinListener;

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
        manager.registerEvents(new InteractEventDispatcher(), this);
        manager.registerEvents(new EntityHitEntityEventDispatcher(), this);
        /* register implementation listeners */
        manager.registerEvents(new EnchantTableInteractListener(), this);
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
        if (label.equalsIgnoreCase("ctestench")) {
            if (args.length < 2) {
                player.sendMessage(ChatColor.RED+"Incorrect syntax.");
                return true;
            }
            EnchantEnum enchant = EnchantEnum.getEnchant(args[0]);
            if (enchant == null) {
                player.sendMessage(ChatColor.RED + "Couldn't find enchant with name " + args[0] + ".");
                return true;
            }
            PassiveEnchant<Player> passiveEnchant;
            if (!enchant.isPassive()) {
                player.sendMessage(ChatColor.RED + "You can only test passive enchants.");
                return true;
            }
            passiveEnchant = (PassiveEnchant) enchant.getEnchant();
            passiveEnchant.fire(player, Integer.parseInt(args[1]));
            player.sendMessage("Testing enchant "+passiveEnchant.getId()+".");
        }

        if (label.equalsIgnoreCase("cenchant"))

        {
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
