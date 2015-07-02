package Q17_11_Word_Distance;

import java.util.ArrayList;
import java.util.HashMap;

import CtCILibrary.AssortedMethods;
import CtCILibrary.HashMapList;

public class Tester {
	
	public static String wordAtLocation(String[] words, int loc) {
		if (loc < 0 || loc >= words.length) {
			return null;
		}
		return words[loc];
	}
	
	// Method to confirm other result
	public static boolean searchConfirm(String[] words, String word1, String word2, int distance) {
		boolean found_at_distance = false;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				for (int j = 1; j < distance; j++) {
					String loc2a = wordAtLocation(words, i - j);
					String loc2b = wordAtLocation(words, i + j);
					if (word2.equals(loc2a) || word2.equals(loc2b)) {
						return false;
					}
				}
				
				String loc2a = wordAtLocation(words, i - distance);
				String loc2b = wordAtLocation(words, i + distance);
				if (word2.equals(loc2a) || word2.equals(loc2b)) {
					found_at_distance = true;
				}
			}
		}
		return found_at_distance;
	}
	
	public static void main(String[] args) {
		String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
		System.out.println(AssortedMethods.stringArrayToString(wordlist));
		HashMapList<String, Integer> locations = QuestionB.getWordLocations(wordlist);
		
		String[][] pairs = {{"Lara", "the"}, {"river", "life"}, {"path", "their"}, {"life", "a"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			LocationPair pairA = QuestionA.findClosest(wordlist, word1, word2);
			LocationPair pairB = QuestionB.findClosest(word1, word2, locations);
			boolean confirmC = searchConfirm(wordlist, word1, word2, pairA.distance());
			
			System.out.println("Distance between <" + word1 + "> and <" + word2 + ">: " + confirmC);
			System.out.println(pairA.toString() + ": " + pairA.distance());
			System.out.println(pairB.toString() + ": " + pairB.distance());
			System.out.println();
		}
	}

}
