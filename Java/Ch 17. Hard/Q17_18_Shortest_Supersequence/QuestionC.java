package Q17_18_Shortest_Supersequence;

public class QuestionC {

	public static Range shortestSupersequence(int[] big, int[] small) {
		int[] closures = getClosures(big, small);
		return getShortestClosure(closures);
	}
	
	/* Get closure for each index. */
	public static int[] getClosures(int[] big, int[] small) {
		int[] closure = new int[big.length];
		for (int i = 0; i < small.length; i++) {
			sweepForClosure(big, closure, small[i]);
		}
		return closure;
	}	
	
	/* Do backwards sweep and update the closures list with the next occurrence of value, if it's later than the current closure*/
	public static void sweepForClosure(int[] big, int[] closures, int value) {
		int next = -1;
		for (int i = big.length - 1; i >= 0; i--) {
			if (big[i] == value) {
				next = i;
			}
			if ((next == -1 || closures[i] < next) && (closures[i] != -1)) {
				closures[i] = next;
			}
		}
	}
	
	/* Get shortest closure. */
	public static Range getShortestClosure(int[] closures) {
		if (closures == null || closures.length == 0) return null;
		Range shortest = new Range(0, closures[0]);
		for (int i = 1; i < closures.length; i++) {
			if (closures[i] == -1) {
				break;
			}
			Range range = new Range(i, closures[i]);
			if (!shortest.shorterThan(range)) {
				shortest = range;
			}
		}
		if (shortest.length() <= 0) return null;
		return shortest;
	}
	
	public static void main(String[] args) {
		int[] array = {9, 2, 4, 6, 2, 5, 9};
		int[] set = {1, 5, 9};
		System.out.println(array.length);
		Range shortest = shortestSupersequence(array, set);
		if (shortest == null) {
			System.out.println("No valid subsequence.");
		} else {
			System.out.println(shortest.getStart() + ", " + shortest.getEnd());
		}

	}

}
