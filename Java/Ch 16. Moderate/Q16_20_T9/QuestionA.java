package Q16_20_T9;

import java.util.ArrayList;
import java.util.HashSet;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TrieNode;

public class QuestionA {
	public static char[][] t9Letters = {
			null, 					// 0
			null, 					// 1
			{'a', 'b', 'c'}, 		// 2
			{'d', 'e', 'f'}, 		// 3
			{'g', 'h', 'i'}, 		// 4
			{'j', 'k', 'l'},		// 5
			{'m', 'n', 'o'},		// 6
			{'p', 'q', 'r', 's'}, 	// 7
			{'t', 'u', 'v'},		// 8
			{'w', 'x', 'y', 'z'} 	// 9
	};
	
	public static char[] getT9Chars(char digit) {
		if (!Character.isDigit(digit)) {
			return null;
		}
		int dig = Character.getNumericValue(digit) - Character.getNumericValue('0');
		return t9Letters[dig];
	}
	
	public static void getValidWords(String number, int index, String prefix, HashSet<String> wordSet, ArrayList<String> results) {
		/* If it's a complete word, print it. */
		if (index == number.length() ) {
			if (wordSet.contains(prefix)) {
				results.add(prefix);
			}
			return;
		}
		
		/* Get characters that match this digit */
		char digit = number.charAt(index);
		char[] letters = getT9Chars(digit);
		
		/* Go through all remaining options. */
		if (letters != null) {
			for (char letter : letters) {
				getValidWords(number, index + 1, prefix + letter, wordSet, results);
			}
		}
	}
	
	public static ArrayList<String> getValidT9Words(String number, HashSet<String> wordList) {
		ArrayList<String> results = new ArrayList<String>();
		getValidWords(number, 0, "", wordList, results);
		return results;
	}
	
	public static void main(String[] args) {
		ArrayList<String> words = getValidT9Words("33835676368", AssortedMethods.getWordListAsHashSet());
		for (String w: words) {
			System.out.println(w);
		}
	}

}
