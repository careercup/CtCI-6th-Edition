package Q17_05_Letters_and_Numbers;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char b = 'b';
		char a = '1';
		char[] array = {a, b, a, b, a, b, b, b, b, b, a, a, a, a, a, b, a, b, a, b, b, a, a, a, a, a, a, a};
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println();
		char[] maxA = QuestionA.findLongestSubarray(array);
		char[] maxB = QuestionB.findLongestSubarray(array);
		
		if (maxA == null) {
			System.out.println("A is null.");
		} else {
			System.out.println("A: " + maxA.length);
			for (int i = 0; i < maxA.length; i++) {
				System.out.print(maxA[i] + " ");
			}
			System.out.println("\nIs Valid? " + QuestionA.hasEqualLettersNumbers(maxA, 0, maxA.length - 1));
			System.out.println();
		}
		
		if (maxB == null) {
			System.out.println("B is null.");
		} else {
			System.out.println("B: " + maxB.length);
			for (int i = 0; i < maxB.length; i++) {
				System.out.print(maxB[i] + " ");
			}	
			System.out.println("\nIs Valid? " + QuestionA.hasEqualLettersNumbers(maxB, 0, maxB.length - 1));
		}
	}

}
