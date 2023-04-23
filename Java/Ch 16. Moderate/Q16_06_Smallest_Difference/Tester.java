package Q16_06_Smallest_Difference;

import CtCILibrary.AssortedMethods;

public class Tester {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int size = (int) (Math.random() * 100.0);
			int[] array1 = AssortedMethods.randomArray(size, i * -1, i);
			int[] array2 = AssortedMethods.randomArray(size, i * -1, i);
			int diffA = QuestionA.findSmallestDifference(array1, array2);
			int diffB = QuestionB.findSmallestDifference(array1, array2);
			int diffC = QuestionC.findSmallestDifference(array1, array2);
			if (diffA != diffB || diffB != diffC) {
				diffA = QuestionA.findSmallestDifference(array1, array2);
				diffB = QuestionB.findSmallestDifference(array1, array2);
				diffC = QuestionC.findSmallestDifference(array1, array2);
				System.out.println(diffA);
				System.out.println(diffB);
				System.out.println(diffC);
				System.out.println();
			}
		}
	}
}
