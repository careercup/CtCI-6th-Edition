package Q17_16_The_Masseuse;

public class QuestionA {
	public static int maxMinutes(int[] massages) {
		return maxMinutes(massages, 0);
	}
	
	public static int maxMinutes(int[] massages, int index) {
		if (index >= massages.length) { // Out of bounds
			return 0;
		}
		
		/* Best with this reservation. */
		int bestWith = massages[index] + maxMinutes(massages, index + 2);
		
		/* Best without this reservation. */
		int bestWithout = maxMinutes(massages, index + 1);
		
		/* Return best of this subarray, starting from index. */
		return Math.max(bestWith, bestWithout);
	}
	
	public static void main(String[] args) {
		int[] massages = {30, 15, 60, 75, 45, 15, 15, 45};
		System.out.println(maxMinutes(massages));
	}

}
