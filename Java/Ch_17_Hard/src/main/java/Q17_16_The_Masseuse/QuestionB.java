package Q17_16_The_Masseuse;

public class QuestionB {
	
	public static int maxMinutes(int[] massages) {
		int[] memo = new int[massages.length];
		return maxMinutes(massages, 0, memo);
	}
	
	public static int maxMinutes(int[] massages, int index, int[] memo) {
		if (index >= massages.length) {
			return 0;
		}
		if (memo[index] == 0) {
			int bestWith = massages[index] + maxMinutes(massages, index + 2, memo);
			int bestWithout = maxMinutes(massages, index + 1, memo);
			memo[index] = Math.max(bestWith, bestWithout);
		}
		
		return memo[index];
	}	
	
	public static void main(String[] args) {
		int[] massages = {2*15, 1*15, 4*15, 5*15, 3*15, 1*15, 1*15, 3*15};
		System.out.println(maxMinutes(massages));
	}

}
