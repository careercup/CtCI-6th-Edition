package Introduction;

public class FibonacciB {
	public static int fibonacci(int n) {
		return fibonacci(n, new int[n + 1]);
	}
	
	public static int fibonacci(int i, int[] memo) {
		if (i == 0) return 0;
		else if (i == 1) return 1;
		
		if (memo[i] == 0) {
			memo[i] = fibonacci(i - 1, memo) + fibonacci(i - 2, memo);
		}
		return memo[i];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 100; // Make this as big as you want! (Though you'll exceed the bounds of a long around 46)
		int trials = 10; // Run code multiple times to compute average time.
		double[] times = new double[max]; // Store times
		
		for (int j = 0; j < trials; j++) { // Run this 10 times to compute
			for (int i = 0; i < max; i++) {
				long start = System.currentTimeMillis();
				System.out.println(fibonacci(i));
				long end = System.currentTimeMillis();
				long time = end - start;
				times[i] += time; 
			}
		}
		
		for (int j = 0; j < max; j++) {
			//System.out.println(j + ": " + times[j] / trials + "ms");
		}
	}

}
