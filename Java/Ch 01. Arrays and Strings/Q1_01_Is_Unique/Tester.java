package Q1_01_Is_Unique;

public class Tester {
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			boolean a =  QuestionA.isUniqueChars(word);
			boolean b =  QuestionB.isUniqueChars(word);
			if (a == b) {
				System.out.println(word + ": " + a);
			} else {
				System.out.println(word + ": " + a + " vs " + b);
			}
		}
	}
}
