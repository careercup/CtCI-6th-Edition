package Big_O;

public class Q_05 {

	public static int sqrt(int n) {
	    return sqrt_helper(n, 1, n);
	} 
	
	public static int sqrt_helper(int n, int min, int max) {
	    if (max < min) return -1; // no square root
	    
	    int guess = (min + max) / 2;
	    if (guess * guess == n) { // found it!
	        return guess;
	    } else if (guess * guess < n) { // too low
	        return sqrt_helper(n, guess + 1, max); // try higher
	    } else { // too high
	        return sqrt_helper(n, min, guess - 1); // try lower
	    }
	}
	        
	

	
	public static void main(String[] args) {
		System.out.println(sqrt(26));
	}

}
