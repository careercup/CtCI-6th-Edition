package Q13_05_TreeMap_HashMap_LinkedHashMap;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Question {
	public static void insertAndPrint(AbstractMap<Integer, String> map) {
		int[] array = {1, -1, 0};
		for (int x : array) {
			map.put(x, Integer.toString(x));
		}
		
		for (int k : map.keySet()) {
			System.out.print(k + ", ");
		}
	}
	
	public static void main(String[] args) {
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
		
		System.out.println("\nHashMap - Arbitrary Order:");
		insertAndPrint(hashMap);
		
		System.out.println("\nLinkedHashMap - Insertion Order:");
		insertAndPrint(linkedHashMap);

		System.out.println("\nTreeMap - Natural Order:");
		insertAndPrint(treeMap);
	}

}
