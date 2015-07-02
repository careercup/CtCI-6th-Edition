package Big_O;

public class Ex_02 {
	public static int pairSum(int a, int b) {
		return a + b;
	}
	
	public static int pairSumSequence(int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += pairSum(i, i + 1);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int s = pairSumSequence(4);
		System.out.println(s);
	}		
}
