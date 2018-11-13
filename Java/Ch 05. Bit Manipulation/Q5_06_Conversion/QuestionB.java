package Q5_06_Conversion;

import CtCILibrary.AssortedMethods;

public class QuestionB {
	public static int bitSwapRequired(int a, int b){
		int count = 0;
		int c = a ^ b;

		System.out.println("****");
		System.out.println(c + ": " + AssortedMethods.toFullBinaryString(c));
		while (c != 0) {
			System.out.println("c - 1: " + c + ": " + AssortedMethods.toFullBinaryString(c - 1));
			c = c & (c-1);
			System.out.println("c: " + c + ": " + AssortedMethods.toFullBinaryString(c));
			count++;
			System.out.println("****");
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
