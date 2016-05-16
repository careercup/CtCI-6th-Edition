package Big_O;

public class Q_01 {

	public static int product(int a, int b) {
	    int sum = 0;
	    for (int i = 0; i < b; i++) {
	        sum += a;
	    }
	    return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(product(5, 6));
	}

}
