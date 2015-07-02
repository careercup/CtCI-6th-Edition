package Q17_16_The_Masseuse;

public class QuestionC {
	public static int maxMinutes(int[] massages) {
		/* Allocating two extra slots in the array so we don't have to do bounds
		   * checking on lines 7 and 8. */		
		int[] memo = new int[massages.length + 2];
		memo[massages.length] = 0;
		memo[massages.length + 1] = 0;
		for (int i = massages.length - 1; i >= 0; i--) {
			int bestWith = massages[i] + memo[i + 2];
			int bestWithout = memo[i + 1];
			memo[i] = Math.max(bestWith, bestWithout);
		}
		return memo[0];
	}
	
	public static void main(String[] args) {
		int[] massages = {2*15, 1*15, 4*15, 5*15, 3*15, 1*15, 1*15, 3*15};
		System.out.println(maxMinutes(massages));
	}

}
