package Q8_11_Coins;

public class Question {	
	public static int makeChangeHelper(int total, int[] denoms, int index) {
		int coin = denoms[index];
		if (index == denoms.length - 1) { // One denom left, either you can do it or not
			int remaining = total % coin; 
			return remaining == 0 ? 1 : 0;
		}
		int ways = 0;
		/* Try 1 coin, then 2 coins, 3 three, ... (recursing each time on rest). */
		for (int amount = 0; amount <= total; amount += coin) { 
			ways += makeChangeHelper(total - amount, denoms, index + 1); // go to next denom
		}
		return ways;
	}
	
	public static int makeChange(int amount, int[] denoms) {
		return makeChangeHelper(amount, denoms, 0);
	}
	
	public static void main(String[] args) {
		int[] denoms = {25, 10, 5, 1};
		int ways = makeChange(10, denoms);
		System.out.println(ways);
	}

}