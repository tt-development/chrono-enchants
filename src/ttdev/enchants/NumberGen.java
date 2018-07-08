package ttdev.enchants;

import java.util.Random;

public class NumberGen {

	public static boolean generate(int chance) {
		Random random = new Random();
		int r = random.nextInt(100) + 1;
		
		if (chance < (r + 1)) {
			return true;
		}
		return false;
	}
	
}
