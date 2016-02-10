package Q17_22_Word_Transformer;

import CtCILibrary.HashMapList;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class QuestionC {

	public static Deque<String> transform(String startWord, String stopWord, String[] words) {
		HashMapList<String, String> wildcardToWordList = getWildcardToWordList(words);
		
		BFSData sourceData = new BFSData(startWord);
		BFSData destData = new BFSData(stopWord);
		
		while (!sourceData.isFinished() && !destData.isFinished()) {
			/* Search out from source. */
			String collision = searchLevel(wildcardToWordList, sourceData, destData);
			if (collision != null) {
				return mergePaths(sourceData, destData, collision);
			}
			
			/* Search out from destination. */
			collision = searchLevel(wildcardToWordList, destData, sourceData);
			if (collision != null) {
				return mergePaths(sourceData, destData, collision);
			}
		}
		
		return null;
	}
	
	/* Search one level and return collision, if any. */
	public static String searchLevel(HashMapList<String, String> wildcardToWordList, BFSData primary, BFSData secondary) {
		/* We only want to search one level at a time. Count how many nodes are currently in the primary's
		 * level and only do that many nodes. We'll continue to add nodes to the end. */
		int count = primary.toVisit.size(); 
		for (int i = 0; i < count; i++) {
			/* Pull out first node. */
			PathNode pathNode = primary.toVisit.poll();
			String word = pathNode.getWord();
			
			/* Check if it's already been visited. */
			if (secondary.visited.containsKey(word)) {
				return pathNode.getWord();
			}				
			
			/* Add friends to queue. */
			List<String> words = getValidLinkedWords(word, wildcardToWordList);
			for (String w : words) {
				if (!primary.visited.containsKey(w)) {
					PathNode next = new PathNode(w, pathNode);
					primary.visited.put(w, next);
					primary.toVisit.add(next);
				}
			}
		}
		return null;
	}

	public static Deque<String> mergePaths(BFSData bfs1, BFSData bfs2, String connection) {
		PathNode end1 = bfs1.visited.get(connection); // end1 -> source
		PathNode end2 = bfs2.visited.get(connection); // end2 -> dest
		Deque<String> pathOne = end1.collapse(false); // forward: source -> connection
		Deque<String> pathTwo = end2.collapse(true); // reverse: connection -> dest
		pathTwo.removeFirst(); // remove connection
		pathOne.addAll(pathTwo); // add second path
		return pathOne;
	}

	public static List<String> getWildcardRoots(String word) {
		List<String> words = new ArrayList<String>();
		for (int i = 0; i < word.length(); i++) {
			String w = word.substring(0, i) + "_" + word.substring(i + 1);
			words.add(w);
		}
		return words;
	}	
	
	public static HashMapList<String, String> getWildcardToWordList(String[] words) {
		HashMapList<String, String> wildcardToWords = new HashMapList<String, String>();
		for (String word : words) {
			List<String> linked = getWildcardRoots(word);
			for (String linkedWord : linked) {
				wildcardToWords.put(linkedWord, word);
			}
		}
		return wildcardToWords;
	}

	public static List<String> getValidLinkedWords(String word, HashMapList<String, String> wildcardToWords) {
		List<String> wildcards = getWildcardRoots(word);
		List<String> linkedWords = new ArrayList<String>();
		for (String wildcard : wildcards) {
			Iterable<String> words = wildcardToWords.get(wildcard);
			for (String linkedWord : words) {
				if (!linkedWord.equals(word)) {
					linkedWords.add(linkedWord);
				}
			}
		}
		return linkedWords;
	}	

	public static void main(String[] args) {
		String[] words = {"maps", "tan", "tree", "apple", "cans", "help", "aped", "pree", "pret", "apes", "flat", "trap", "fret", "trip", "trie", "frat", "fril"};
		Deque<String> list = transform("tree", "flat", words);
		
		if (list == null) {
			System.out.println("No path.");
		} else {
			System.out.println(list.toString());
		}
	}

}
