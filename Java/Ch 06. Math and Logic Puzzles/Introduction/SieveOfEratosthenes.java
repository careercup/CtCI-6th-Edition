package Introduction;

public class SieveOfEratosthenes {
	
	public static void crossOff(boolean[] flags, int prime) {
		/* Cross off remaining multiples of prime. We can start with
		 * (prime*prime), because if we have a k * prime, where k < prime,
		 * this value would have already been crossed off in a prior
		 * iteration. */		
		for (int i = prime * prime; i < flags.length; i += prime) {
			flags[i] = false;
		}
	}
	
	public static int getNextPrime(boolean[] flags, int prime) {
		int next = prime + 1;
		while (next < flags.length && !flags[next]) {
			next++;
		}
		return next;	
	}
	
	public static void init(boolean[] flags) {
		flags[0] = false;
		flags[1] = false;
		for (int i = 2; i < flags.length; i++) {
			flags[i] = true;
		}
	}
	
	public static int[] prune(boolean[] flags, int count) {
		int[] primes = new int[count];
		int index = 0;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i]) {
				primes[index] = i;
				index++;
			}
		}
		return primes;
	}
	
	public static boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max + 1];
        
		init(flags);
        int prime = 2;
        
        while (prime <= Math.sqrt(max)) {       	
    		/* Cross off remaining multiples of prime */   
    		crossOff(flags, prime); 

    		/* Find next value which is true */
    		prime = getNextPrime(flags, prime);
        }
        
        return flags; //prune(flags, count);
	}
	
	public static void main(String[] args) {
		boolean[] primes = sieveOfEratosthenes(4);
		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				System.out.println(i);
			}
		}
	}

}
