package Q17_18_Shortest_Supersequence;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {9, 5, 1, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 9, 7};
		int[] set = {1, 5, 9};
		
		Range shortestA = QuestionA.shortestSupersequence(array, set);
		Range shortestB = QuestionB.shortestSupersequence(array, set);
		Range shortestC = QuestionC.shortestSupersequence(array, set);
		Range shortestD = QuestionD.shortestSupersequence(array, set);
		
		
		if (shortestA.length() != shortestB.length() || 
			shortestB.length() != shortestC.length() || 
			shortestC.length() != shortestD.length()) {
			System.out.println("Mismatching.");
		} else {
			System.out.println("Matching: " + shortestA.length());
		}
	}

}
