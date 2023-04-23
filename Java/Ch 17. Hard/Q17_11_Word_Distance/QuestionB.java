package Q17_11_Word_Distance;

import java.util.ArrayList;
import java.util.HashMap;

import CtCILibrary.AssortedMethods;
import CtCILibrary.HashMapList;

public class QuestionB {
	
	public static HashMapList<String, Integer> getWordLocations(String[] words) {
		HashMapList<String, Integer> locations = new HashMapList<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			locations.put(words[i], i);
		}
		return locations;
	}
	
	public static LocationPair findMinDistancePair(ArrayList<Integer> array1, ArrayList<Integer> array2) {
		if (array1 == null || array2 == null || array1.size() == 0 || array2.size() == 0) {
			return null;
		}
		
		int index1 = 0;
		int index2 = 0;
		LocationPair best = new LocationPair(array1.get(0), array2.get(0));
		LocationPair current = new LocationPair(array1.get(0), array2.get(0));
		
		while (index1 < array1.size() && index2 < array2.size()) {
			current.setLocations(array1.get(index1), array2.get(index2));
			best.updateWithMin(current);
			if (current.location1 < current.location2) {
				index1++;
			} else {
				index2++;
			}
		}	
		
		return best;
	}
	
	public static LocationPair findClosest(String word1, String word2, HashMapList<String, Integer> locations) {
		ArrayList<Integer> locations1 = locations.get(word1);
		ArrayList<Integer> locations2 = locations.get(word2);		
		return findMinDistancePair(locations1, locations2);
	}
	
	public static void main(String[] args) {
		String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
		String word1 = "river";
		String word2 = "life";
		HashMapList<String, Integer> locations = getWordLocations(wordlist);
		LocationPair pair = findClosest(word1, word2, locations);
		System.out.println("Distance between <" + word1 + "> and <" + word2 + ">: " + pair.toString());		
	}

}
