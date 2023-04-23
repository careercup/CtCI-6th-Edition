package Q5_06_Conversion;

import CtCILibrary.AssortedMethods;

public class QuestionB {
	public static int bitSwapRequired(int a, int b){
		int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c-1)) {
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int a = -23432;
		int b = 512132;
		System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
		System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
		System.out.println("Required number of bits: " + bitSwapRequired(a, b));
	}
}
