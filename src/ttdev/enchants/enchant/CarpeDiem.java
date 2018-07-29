package ttdev.enchants.enchant;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import ttdev.enchants.ChronoEnchants;
import ttdev.enchants.api.enchant.EnchantTrigger;
import ttdev.enchants.api.enchant.GenericEnchant;

public class CarpeDiem extends GenericEnchant<Void> {

    public CarpeDiem() {
        super("carpediem", EnchantTrigger.NONE);
        super.setDisplayName(ChatColor.WHITE + "Carpe Diem");
    }

    @Override
    public void trigger(ItemStack item, int level, Player player, Void aVoid) {
        System.out.println("In trigger method of Carpe Diem");
        new EnchantRunnable(player).runTaskAsynchronously(ChronoEnchants.getInstance());
    }

    private class EnchantRunnable extends BukkitRunnable {

        private Player player;

        private EnchantRunnable(Player player) {
            this.player = player;
        }

        @Override
        public void run() {

            //TODO Finish implementing Carpe Diem

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            if(!player.isBlocking()){
                return;
            }

            while (player.isBlocking()) {
                player.sendMessage("Carpe Diem ready");
            }

            player.sendMessage("Launch!");

        }

    }
}
