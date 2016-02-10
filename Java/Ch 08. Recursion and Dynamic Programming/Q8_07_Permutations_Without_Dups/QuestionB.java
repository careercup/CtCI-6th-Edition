package Q8_07_Permutations_Without_Dups;

import java.util.ArrayList;
import java.util.List;

public class QuestionB {
	public static List<String> getPerms(String remainder) {
		int len = remainder.length();
		List<String> result = new ArrayList<>();
		
		/* Base case. */
		if (len == 0) {
			result.add(""); // Be sure to return empty string!
			return result;
		}
		
		
		for (int i = 0; i < len; i++) {
			/* Remove char i and find permutations of remaining characters.*/
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			List<String> partials = getPerms(before + after);
			
			/* Prepend char i to each permutation.*/
			for (String s : partials) {
				result.add(remainder.charAt(i) + s);
			}			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		List<String> list = getPerms("abc");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
	}

}
