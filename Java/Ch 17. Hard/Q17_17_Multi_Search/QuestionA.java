package Q17_17_Multi_Search;

import CtCILibrary.HashMapList;

import java.util.ArrayList;
import java.util.List;

public class QuestionA {
	public static boolean isSubstringAtLocation(CharSequence big, CharSequence small, int offset) {
		for (int i = 0; i < small.length(); i++) {
			if (big.charAt(offset + i) != small.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static List<Integer> search(CharSequence big, CharSequence small) {
		List<Integer> locations = new ArrayList<>();
		for (int i = 0; i < big.length() - small.length() + 1; i++) {
			if (isSubstringAtLocation(big, small, i)) {
				locations.add(i);
			}
		}
		return locations;
	}

	public static HashMapList<String, Integer> searchAll(CharSequence big, String[] smalls) {
		HashMapList<String, Integer> lookup = new HashMapList<>();
		for (String small : smalls) {
			List<Integer> locations = search(big, small);
			lookup.put(small, locations);
		}
		return lookup;
	}
	
	public static void main(String[] args) {
		String big = "mississippi";
		String[] smalls = {"is", "ppi", "hi", "sis", "i", "mississippi"};
		HashMapList<String, Integer> locations = searchAll(big, smalls);
		System.out.println(locations);
	}
}