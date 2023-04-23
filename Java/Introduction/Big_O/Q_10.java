package Big_O;

public class Q_10 {

	public static int sumDigits(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(sumDigits(1252));
	}
}
