package Q17_01_Add_Without_Plus;

public class QuestionB {

	public static int add(int a, int b) {
		while (b != 0) {
			int sum = a ^ b; // add without carrying
			int carry = (a & b) << 1; // carry, but don't add			
			a = sum;
			b = carry;
		}
		return a;
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
