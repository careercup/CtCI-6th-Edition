package Q5_01_Insertion;

import CtCILibrary.AssortedMethods;

public class QuestionB {
	public static int updateBits(int n, int m, int i, int j) {
		int mask = ~(~0 >>> (i - j - 1) << i);
		return (n & mask) | (m << i);
	}

	public static void main(String[] args) {
		int n = 103217;
		System.out.println(AssortedMethods.toFullBinaryString(n));
		int m = 13;
		System.out.println(AssortedMethods.toFullBinaryString(m));
		int c = updateBits(n, m, 4, 12);
		System.out.println(AssortedMethods.toFullBinaryString(c));
	}
}
