package Q1_01_Is_Unique;

public class Tester {
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			boolean wordA =  QuestionA.isUniqueChars(word);
			boolean wordB =  QuestionB.isUniqueChars(word);
			if (wordA == wordB) {
				System.out.println(word + ": " + wordA);
			} else {
				System.out.println(word + ": " + wordA + " vs " + wordB);
			}
		}
	}
}
