package Q17_17_Multi_Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode {
	private Map<Character, TrieNode> children;
	private List<Integer> indexes;
	private char value;
	
	public TrieNode() {
		children = new HashMap<>();
		indexes = new ArrayList<>();
	}
	
	
	public void insertString(String s, int index) {
		indexes.add(index);
		if (s != null && s.length() > 0) {
			value = s.charAt(0);
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

	public List<Integer> search(String s) {
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

