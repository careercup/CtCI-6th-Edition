package Big_O;

public class Q_03 {

	public static int mod(int a, int b) {
	    if (b <= 0) {
	        return -1;
	    }
	    int div = a / b;
	    return a - div * b;
	}
	
	public static void main(String[] args) {
		System.out.println(mod(3, 6));
	}

}
