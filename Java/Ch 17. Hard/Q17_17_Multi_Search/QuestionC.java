package Q17_17_Multi_Search;

import java.util.ArrayList;

import CtCILibrary.HashMapList;

public class QuestionC {
	public static Trie createTreeFromStrings(String[] smalls, int maxSize) {
        Trie tree = new Trie();
		for (String s : smalls) {
			if (s.length() <= maxSize) {
				tree.insertString(s, 0);
			}
		}
		return tree;
	}
	
	public static ArrayList<String> findStringsAtLoc(TrieNode root, String big, int start) {
		ArrayList<String> strings = new ArrayList<String>();
		int index = start;
		while (index < big.length()) {
			root = root.getChild(big.charAt(index));
			if (root == null) break;
			if (root.terminates()) {
				strings.add(big.substring(start, index + 1));
			}
			index++;
			
		}
		return strings;
	}
	
	public static void insertIntoHashMap(ArrayList<String> strings, HashMapList<String, Integer> map, int index) {
		for (String s : strings) {
			map.put(s, index);
		}
	}
	
	public static HashMapList<String, Integer> searchAll(String big, String[] smalls) {
		HashMapList<String, Integer> lookup = new HashMapList<String, Integer>();
		TrieNode root = createTreeFromStrings(smalls, big.length()).getRoot();
		
		for (int i = 0; i < big.length(); i++) {
			ArrayList<String> strings = findStringsAtLoc(root, big, i);
			insertIntoHashMap(strings, lookup, i);
		}
		
		return lookup;
	}	
	
	public static void main(String[] args) {
		String big = "mississippi";
		String[] smalls = {"is", "ppi", "hi", "sis", "i", "mississippi"};
		HashMapList<String, Integer> locations = searchAll(big, smalls);
        System.out.println(locations.toString());
	}
}