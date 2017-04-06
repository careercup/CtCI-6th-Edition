package Q1_01_Is_Unique;

import java.util.BitSet;

public class QuestionB {
	public static boolean isUniqueChars(String str) {
		BitSet checker = new BitSet();
		for (int c : str.toCharArray()) {
			if (checker.get(c)) return false;
			else checker.set(c);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}

}
