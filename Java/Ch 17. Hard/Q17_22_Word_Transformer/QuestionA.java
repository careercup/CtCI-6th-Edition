package Q17_22_Word_Transformer;

import java.util.*;

public class QuestionA {

	public static List<String> wordsOneAway(String word) {
		List<String> words = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				String w = word.substring(0, i) + c + word.substring(i + 1);
				words.add(w);
			}
		}		
		return words;
	}

	public static LinkedList<String> transform(Set<String> visited, String startWord, String stopWord, Set<String> dictionary) {
		if (startWord.equals(stopWord)) {
			LinkedList<String> path = new LinkedList<>();
			path.add(startWord);
			return path;
		} else if (visited.contains(startWord) || !dictionary.contains(startWord)) {
			return null;
		}

		visited.add(startWord);
		List<String> words = wordsOneAway(startWord);
		
		for (String word : words) {
			LinkedList<String> path = transform(visited, word, stopWord, dictionary);
			if (path != null) {
				path.addFirst(startWord);
				return path;
			}
		}
		
		return null;
	}

	public static Deque<String> transform(String start, String stop, String[] words) {
		Set<String> dict = setupDictionary(words);
		Set<String> visited = new HashSet<>();
		return transform(visited, start, stop, dict);
	}

	public static Set<String> setupDictionary(String[] words) {
		Set<String> hash = new HashSet<>();
		for (String word : words) {
			hash.add(word.toLowerCase());
		}
		return hash;
	}

	public static void main(String[] args) {
		String[] words = {"maps", "tan", "tree", "apple", "cans", "help", "aped", "pree", "pret", "apes", "flat", "trap", "fret", "trip", "trie", "frat", "fril"};
		Deque<String> list = transform("tree", "flat", words);
		
		if (list == null) {
			System.out.println("No path.");
		} else {
			System.out.println(list);
		}
	}

}
