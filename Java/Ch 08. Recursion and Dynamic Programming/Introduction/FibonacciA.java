package Introduction;

public class FibonacciA {
	public static int fibonacci(int i) {
		if (i == 0) {
			return 0;
		}
		if (i == 1) {
			return 1;
		}
		return fibonacci(i - 1) + fibonacci(i - 2);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 35; // WARNING: If you make this above 40ish, your computer may serious slow down.
		int trials = 10; // Run code multiple times to compute average time.
		double[] times = new double[max]; // Store times
		
		
		for (int j = 0; j < trials; j++) { // Run this 10 times to compute
			for (int i = 0; i < max; i++) {
				long start = System.currentTimeMillis();
				fibonacci(i);
				long end = System.currentTimeMillis();
				long time = end - start;
				times[i] += time; 
			}
		}
		
		for (int j = 0; j < max; j++) {
			System.out.println(j + ": " + times[j] / trials + "ms");
		}
	}

}
