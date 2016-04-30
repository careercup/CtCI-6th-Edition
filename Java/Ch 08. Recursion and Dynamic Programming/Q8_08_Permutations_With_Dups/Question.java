package Q8_08_Permutations_With_Dups;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question {
	public static Map<Character, Integer> buildFreqTable(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}
		return map;
	}

	public static void printPerms(Map<Character, Integer> map, String prefix, int remaining, List<String> result) {
		if (remaining == 0) {
			result.add(prefix);
			return;
		}
		
		for (Character c : map.keySet()) {
			int count = map.get(c);
			if (count > 0) {
				map.put(c,  count - 1);
				printPerms(map, prefix + c, remaining - 1, result);
				map.put(c,  count);
			}
		}
	}

	public static List<String> printPerms(String s) {
		List<String> result = new ArrayList<>();
		Map<Character, Integer> map = buildFreqTable(s);
		printPerms(map, "", s.length(), result);
		return result;
	}
	
	public static void main(String[] args) {
		String s = "aabbccc";
		List<String> result = printPerms(s);
		System.out.println("Count: " + result.size());
		for (String r : result) {
			System.out.println(r);
		}
	}

}
