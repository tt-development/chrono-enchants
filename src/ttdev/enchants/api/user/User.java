package ttdev.enchants.api.user;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class User {

	private Player player;
	
	private long combatTime;
	
	private ArrayList<String> activeEnchants = new ArrayList<>();
	
	public User(Player player) {
		this.setPlayer(player);
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getCombatDelay() {
		int time = (int) ((int) System.currentTimeMillis() - this.combatTime);
		return time;
	}
	
	public void setCombatTime(long combatDelay) {
		this.combatTime = combatDelay;
	}
	
	public void addEnchant(String enchant) {
		this.activeEnchants.add(enchant);
	}
	
	public void removeEnchant(String enchant) {
		this.activeEnchants.remove(enchant);
	}
	
	public boolean containsEnchant(String enchant) {
		return this.activeEnchants.contains(enchant);
	}
	
	public ArrayList<String> getEnchants() {
		return this.activeEnchants;
	}
	
}
