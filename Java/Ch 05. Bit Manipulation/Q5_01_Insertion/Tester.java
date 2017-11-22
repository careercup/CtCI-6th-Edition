package Q5_01_Insertion;

import CtCILibrary.AssortedMethods;

public class Tester {
	public static void main(String[] args) {
		int n = ~0;
		int m = 0b1101;

		int resultA = QuestionA.updateBits(n, m, 4, 12);
		int resultB = QuestionB.updateBits(n, m, 4, 12);
		if (resultA != resultB) {
			System.err.println("ERROR:");
			System.out.println(AssortedMethods.toFullBinaryString(resultA));
			System.out.println(AssortedMethods.toFullBinaryString(resultB));
		} else {
			System.out.println("SUCCESS!");
		}
	}
}
