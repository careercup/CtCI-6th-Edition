package Q17_18_Shortest_Supersequence;

import CtCILibrary.AssortedMethods;

public class Tester {
	public static boolean equivalent(Range[] ranges) {
		if (ranges[0] == null) {
			for (Range r : ranges) {
				if (r != null) return false;
			}
			return true;
		}
		
		int targetLength = ranges[0].length();
		for (Range r : ranges) {
			int length = r == null ? 0 : r.length();
			if (targetLength != length) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int[] array = AssortedMethods.randomArray(i,  0,  15);
			int[] set = {0, 5, 8, 10};
			
			Range[] ranges = new Range[5];
			
			ranges[0] = QuestionA.shortestSupersequence(array, set);
			ranges[1] = QuestionB.shortestSupersequence(array, set);
			ranges[2] = QuestionC.shortestSupersequence(array, set);
			ranges[3] = QuestionD.shortestSupersequence(array, set);
			ranges[4] = QuestionE.shortestSupersequence(array, set);
			
			if (!equivalent(ranges)) {
				System.out.println("Mismatching.");
			} else {
				int length = ranges[0] == null ? 0 : ranges[0].length();
				System.out.println("Matching: " + length);
			}
		}
	}

}
