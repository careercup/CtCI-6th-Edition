package Big_O;

public class Q_11 {

	public static int numChars = 26;
	
	public static void printSortedStrings(int remaining) {
		printSortedStrings(remaining, "");
	}
	
	public static void printSortedStrings(int remaining, String prefix) {
		if (remaining == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < numChars; i++) {
				char c = ithLetter(i);
				printSortedStrings(remaining - 1, prefix + c);
			}
		}
	}
	
	public static boolean isInOrder(String s) {
		for (int i = 1; i < s.length(); i++) {
			int prev = ithLetter(s.charAt(i - 1));
			int curr = ithLetter(s.charAt(i));
			if (prev > curr) {
				return false;
			}
		}
		return true;
	}
	
	public static char ithLetter(int i) {
		return (char) (((int) 'a') + i);
	}
	
	public static void main(String[] args) {
		printSortedStrings(3);
	}
}
