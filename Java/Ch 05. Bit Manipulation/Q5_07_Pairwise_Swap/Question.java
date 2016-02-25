package Q5_07_Pairwise_Swap;

import CtCILibrary.AssortedMethods;

public class Question {
	private final static int ODD_MASK = 0b01010101_01010101_01010101_01010101;

	public static int swapOddEvenBits(int num) {
		return ((num >> 1) & ODD_MASK) | ((num & ODD_MASK) << 1);
	}

	public static void main(String[] args) {
		int a = 234321;
		System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
		int b = swapOddEvenBits(a);
		System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
	}
}
