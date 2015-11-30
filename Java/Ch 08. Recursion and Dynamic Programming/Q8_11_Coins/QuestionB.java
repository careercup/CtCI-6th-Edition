package Q8_11_Coins;

public class QuestionB {

	public static long makeChange(int n, int[] denoms) {
		long[][] map = new long[n + 1][denoms.length];
		return makeChange(n, denoms, 0, map);
	}
	
	public static long makeChange(int amount, int[] denoms, int index, long[][] map) {
		if (map[amount][index] > 0) { // retrieve value
			return map[amount][index];
		}
		if (index >= denoms.length - 1) return 1; // one denom remaining -> one way to do it
		int denomAmount = denoms[index];
		long ways = 0;
		for (int i = 0; i * denomAmount <= amount; i++) {
			// go to next denom, assuming i coins of denomAmount
			int amountRemaining = amount - i * denomAmount;
			ways += makeChange(amountRemaining, denoms, index + 1, map);
		}
		map[amount][index] = ways;
		return ways;
	}	
	
	public static void main(String[] args) {
		int[] denoms = {25, 10, 5, 1};
		long ways = makeChange(100000, denoms);
		System.out.println(ways);
	}

}
