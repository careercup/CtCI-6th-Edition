package Q17_15_Longest_Word;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {
	public int compare(String o1, String o2) {
		if (o1.length() < o2.length()) return 1;
		if (o1.length() > o2.length()) return -1;
		return 0;
	}
}
