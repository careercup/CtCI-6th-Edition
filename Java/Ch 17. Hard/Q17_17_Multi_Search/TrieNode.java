package Q17_17_Multi_Search;

import java.util.ArrayList;
import java.util.HashMap;

public class TrieNode {
	private HashMap<Character, TrieNode> children;
	private ArrayList<Integer> indexes;
	
	public TrieNode() { 
		children = new HashMap<Character, TrieNode>();
		indexes = new ArrayList<Integer>();
	}
	
	
	public void insertString(String s, int index) {
		if (s == null) return;
		indexes.add(index);
		if (s.length() > 0) {
			char value = s.charAt(0);
			TrieNode child = null;
			if (children.containsKey(value)) {
				child = children.get(value);
			} else {
				child = new TrieNode();
				children.put(value, child);
			}
			String remainder = s.substring(1);
			child.insertString(remainder, index + 1);
		} else {
			children.put('\0', null);
		}
	}
	
	public ArrayList<Integer> search(String s) {
		if (s == null || s.length() == 0) {
			return indexes;
		} else {
			char first = s.charAt(0);
			if (children.containsKey(first)) {
				String remainder = s.substring(1);
				return children.get(first).search(remainder);
			}
		}
		return null;
	}
	
	public boolean terminates() {
		return children.containsKey('\0');
	}
	
	public TrieNode getChild(char c) {
		return children.get(c);
	}
}

