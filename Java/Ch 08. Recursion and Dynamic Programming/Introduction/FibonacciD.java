package Introduction;

public class FibonacciD {
	public static int fibonacci(int n) {
		if (n == 0) return 0;
		int a = 0;
		int b = 1;
		for (int i = 2; i < n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return a + b;
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
