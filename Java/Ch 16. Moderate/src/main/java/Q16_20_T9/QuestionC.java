package Q16_20_T9;

import java.util.ArrayList;
import java.util.HashMap;

import CtCILibrary.AssortedMethods;
import CtCILibrary.HashMapList;

public class QuestionC {
	public static int numLetters = 26;
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
	
	/* Convert from a string to its T9 representation. */
	public static String convertToT9(String word, HashMap<Character, Character> letterToNumberMap) {
		StringBuilder sb = new StringBuilder();
		for (char c : word.toCharArray()) {
			if (letterToNumberMap.containsKey(c)) {
				char digit = letterToNumberMap.get(c);
				sb.append(digit);
			}
		}
		return sb.toString();
	}
	
	/* Convert mapping of number->letters into letter->number */
	public static HashMap<Character, Character> createLetterToNumberMap() {
		HashMap<Character, Character> letterToNumberMap = new HashMap<Character, Character>();
		for (int i = 0; i < t9Letters.length; i++) {
			char[] letters = t9Letters[i];
			if (letters != null) {
				for (char letter : letters) {
					char c = Character.forDigit(i, 10);
					letterToNumberMap.put(letter, c);
				}
			}
		}		
		return letterToNumberMap;
	}
	
	/* Create a hash table that maps from a number to all words that
	 * have this numerical representation. */
	public static HashMapList<String, String> initializeDictionary(String[] words) {
		/* Create hash table that maps from a letter to the digit */
		HashMap<Character, Character> letterToNumberMap = createLetterToNumberMap();
		
		/* Create word -> number map */
		HashMapList<String, String> wordsToNumbers = new HashMapList<String, String>(); 
		for (String word : words) {
			String numbers = convertToT9(word, letterToNumberMap);
			wordsToNumbers.put(numbers, word);
		}
		return wordsToNumbers;
	}
	
	public static ArrayList<String> getValidT9Words(String numbers, HashMapList<String, String> dictionary) {
		return dictionary.get(numbers);
	}
	
	public static void main(String[] args) {
		HashMapList<String, String> dictionary = initializeDictionary(AssortedMethods.getListOfWords());
		ArrayList<String> words = getValidT9Words("8733", dictionary);
		for (String w: words) {
			System.out.println(w);
		}	

	}

}