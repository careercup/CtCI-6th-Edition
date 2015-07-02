package Introduction;

public class PrimeNumbers {

	public static boolean primeNaive(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean primeSlightlyBetter(int n) {
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}	
	
	public static void main(String[] args) {
		for (int i = 2; i < 100; i++) {
			if (primeSlightlyBetter(i)) {
				System.out.println(i);
			}
		}
	}

}
