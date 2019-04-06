package Q8_08_Permutations_With_Dups;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {	
		public static void getPerms(String prefix, String remainder, ArrayList<String> result) {
		if (remainder.length() == 0) {
			result.add(prefix);
		}
		int len = remainder.length();
		
		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			char c = remainder.charAt(i);

			// Since the intention for avoiding duplicates is that the same
			// character should not come at the same position more than once, we
			// can just check if we have already visited it before and ignore
			// all later combinations.

			if (before.indexOf(c) == -1)
				getPerms(prefix + c, before + after, result);
		}
	}
	
	public static ArrayList<String> getPerms(String str) {
		ArrayList<String> result = new ArrayList<String>();
		getPerms("", str, result);
		return result;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = getPerms("aabbccc");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
	}


}
