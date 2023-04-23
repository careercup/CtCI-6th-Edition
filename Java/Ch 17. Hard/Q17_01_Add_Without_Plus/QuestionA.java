package Q17_01_Add_Without_Plus;

public class QuestionA {

	public static int add(int a, int b) {
		if (b == 0) return a;
		int sum = a ^ b; // add without carrying
		int carry = (a & b) << 1; // carry, but don�t add
		return add(sum, carry); // recurse
	}
	
	public static void main(String[] args) {
		int a = Integer.MAX_VALUE - 50;
		int b = 92;
		int sum = add(a, b);
		int intendedSum = a + b;
		if (sum != intendedSum) {
			System.out.println("ERROR");
		} else {
			System.out.println("SUCCESS");
		}
		System.out.println(a + " + " + b + " = " + sum + " vs " + intendedSum);
	}

}
