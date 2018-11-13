package Q16_16_Sub_Sort;

import CtCILibrary.AssortedMethods;

public class Tester {

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			int[] array = AssortedMethods.randomArray(7, 1, 3);
			Range r1 = Question.findUnsortedSequence(array);
			Range r2 = Question.findUnsortedSequence(array);
			if (r1 == null && r2 == null) {
				continue;
			}
			if (r1 == null || !r1.equals(r2)) {
				System.out.println("ERROR");
				System.out.println(AssortedMethods.arrayToString(array));

				System.out.println(r1 == null ? "null" : r1.toString());

				System.out.println(r2 == null ? "null" : r2.toString());
			}
		}

	}

}
