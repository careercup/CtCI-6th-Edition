package Q17_17_Multi_Search;

import java.util.ArrayList;
import java.util.HashMap;

import CtCILibrary.HashMapList;

public class QuestionB {
	public static void subtractValue(ArrayList<Integer> locations, int delta) {
		if (locations == null) return;
		for (int i = 0; i < locations.size(); i++) {
			locations.set(i, locations.get(i) - delta);
		}
	}
	
	public static Trie createTrieFromString(String s) {
		Trie trie = new Trie();
		for (int i = 0; i < s.length(); i++) {
	    	String suffix = s.substring(i);
	    	trie.insertString(suffix, i);
		}
		return trie;
	}
	
	public static HashMapList<String, Integer> searchAll(String big, String[] smalls) {
		HashMapList<String, Integer> lookup = new HashMapList<String, Integer>();
        Trie tree = createTrieFromString(big);
		for (String s : smalls) {
			/* Get terminating location of each occurrence.*/
        	ArrayList<Integer> locations = tree.search(s);
        	
        	/* Adjust to starting location. */
        	subtractValue(locations, s.length());
        	
        	/* Insert. */
        	lookup.put(s, locations);
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