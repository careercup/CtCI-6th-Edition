package Q17_18_Shortest_Supersequence;

public class QuestionB {

	/* Do backwards sweep to get a list of the next occurrence of value from each index. */
	public static int[] getNextElement(int[] bigArray, int value) {
		int next = -1;
		int[] nexts = new int[bigArray.length];
		for (int i = bigArray.length - 1; i >= 0; i--) {
			if (bigArray[i] == value) {
				next = i;
			}
			nexts[i] = next;
		}
		return nexts;
	}
	
	/* Create table of next occurrences. */ 
	public static int[][] getNextElementsMulti(int[] big, int[] small) {
		int[][] nextElements = new int[small.length][big.length];
		for (int i = 0; i < small.length; i++) {
			nextElements[i] = getNextElement(big, small[i]);
		}
		return nextElements;
	}
	
	/* Given an index and the table of next elements, find the closure
	 * for this index (which will be the min of this column. */
	public static int getClosureForIndex(int[][] nextElements, int index) {
		int max = -1;
		for (int i = 0; i < nextElements.length; i++) {
			if (nextElements[i][index] == -1) {
				return -1;
			}
			max = Math.max(max, nextElements[i][index]);
		}
		return max;
	}
	
	/* Get closure for each index. */
	public static int[] getClosures(int[][] nextElements) {
		int[] maxNextElement = new int[nextElements[0].length];
		for (int i = 0; i < nextElements[0].length; i++) {
			maxNextElement[i] = getClosureForIndex(nextElements, i);
		}
		return maxNextElement;
	}
	
	/* Get shortest closure. */
	public static Range getShortestClosure(int[] closures) {
		int bestStart = -1;
		int bestEnd = -1;
		for (int i = 0; i < closures.length; i++) {
			if (closures[i] == -1) {
				break;
			}
			int current = closures[i] - i;
			if (bestStart == -1 || current < bestEnd - bestStart) {
				bestStart = i;
				bestEnd = closures[i];
			}
		}
		if (bestStart < 0 || bestEnd < 0) {
			return null;
		}
		return new Range(bestStart, bestEnd);
	}
	
	public static Range shortestSupersequence(int[] big, int[] small) {
		int[][] nextElements = getNextElementsMulti(big, small);
		int[] closures = getClosures(nextElements);
		return getShortestClosure(closures);
	}
	
	public static void main(String[] args) {
		int[] array = {9, 5, 1, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 9, 7};
		int[] set = {1, 5, 9};
		System.out.println(array.length);
		Range shortest = shortestSupersequence(array, set);
		System.out.println(shortest.getStart() + ", " + shortest.getEnd());

	}

}
