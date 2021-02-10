package UA_MicroService.BFF_Sync_GenericClasses;

import java.util.Random;

public class RandomNumberGenerator {
	public static Random rand;
public int randomNumber(int num) {
	rand = new Random();
	return rand.nextInt(num);
}
}
