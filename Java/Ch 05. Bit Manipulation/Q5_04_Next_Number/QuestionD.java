package Q5_04_Next_Number;

public class QuestionD {
	public static int getPrev(int n) {
		int ones = trailingOnes(n);
		int zeros = trailingZeros(n >> ones);

		if (ones + zeros >= Integer.SIZE) return -1;
		else return n - pow2(ones) - pow2(zeros - 1) + 1;
	}

	public static int getNext(int n) {
		int zeros = trailingZeros(n);
		int ones = trailingOnes(n >> zeros);

		if (ones + zeros >= Integer.SIZE) return -1;
		else return n + pow2(zeros) + pow2(ones - 1) - 1;
	}

	private static int trailingOnes(int n) { return trailingZeros(~n); }
	private static int trailingZeros(int n) { return Integer.numberOfTrailingZeros(n); }
	private static int pow2(int n) { return 1 << n; }

	public static void main(String[] args) {
		int i = 13948;
		int p1 = getPrev(i);
		int n1 = getNext(i);
		Tester.binPrint(p1);
		Tester.binPrint(n1);
	}
}
