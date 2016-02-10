package Q13_05_TreeMap_HashMap_LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Question {
	public static void insertAndPrint(Map<Integer, String> map) {
		int[] array = {1, -1, 0};
		for (int x : array) {
			map.put(x, Integer.toString(x));
		}
		
		for (int k : map.keySet()) {
			System.out.print(k + ", ");
		}
	}
	
	public static void main(String[] args) {
		Map<Integer, String> treeMap = new TreeMap<>();
		Map<Integer, String> hashMap = new HashMap<>();
		Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
		
		System.out.println("\nHashMap - Arbitrary Order:");
		insertAndPrint(hashMap);
		
		System.out.println("\nLinkedHashMap - Insertion Order:");
		insertAndPrint(linkedHashMap);

		System.out.println("\nTreeMap - Natural Order:");
		insertAndPrint(treeMap);
	}

}
