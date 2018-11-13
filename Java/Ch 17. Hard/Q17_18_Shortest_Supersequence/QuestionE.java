package Q17_18_Shortest_Supersequence;

import java.util.HashMap;

public class QuestionE {
	/* CountedLookup acts a simple hash table with increment/decrement functions
	 * which can efficiently tell you how many values in the hash table are
	 * at least one. 
	 */
	public static class CountedLookup {
		HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();
		int fulfilled = 0;
		public CountedLookup(int[] array) {
			for (int a : array) {
				lookup.put(a, 0);
			}
		}
		
		public boolean contains(int v) {
			return lookup.containsKey(v);
		}
		
		public void incrementIfFound(int v) {
			if (!contains(v)) return;
			if (lookup.getOrDefault(v, 0) == 0) {
				fulfilled += 1;
			}			
			lookup.put(v, lookup.getOrDefault(v, 0) + 1);
		}
		
		public void decrementIfFound(int v) {
			if (!contains(v)) return;
			lookup.put(v, lookup.getOrDefault(v, 0) - 1);
			if (lookup.getOrDefault(v, 0) == 0) {
				fulfilled -= 1;
			}
		}		
		
		public boolean areAllFulfilled() {
			return fulfilled == lookup.keySet().size();
		}
	}
	
	/* Find shortest subarray which contains all elements from small. */
	public static Range shortestSupersequence(int[] big, int[] small) {
		if (big.length < small.length) return null;
		
		CountedLookup countedLookup = new CountedLookup(small);
		Range best = null;
		int right = 0;
		countedLookup.incrementIfFound(big[0]); // Take in left
		for (int left = 0; left < big.length; left++) {
			right = findClosure(big, right, countedLookup); // Move right to closure end
			if (!countedLookup.areAllFulfilled()) { // No closure -> break
				break;
			}
			
			/* Update biggest range. */
			int length = right - left + 1;
			if (best == null || best.length() > length) {
				best = new Range(left, right);
			}
			countedLookup.decrementIfFound(big[left]); // Drop leftmost element
		}
		return best;
	}
	
	/* Find closure for index, and update countedlookup */
	public static int findClosure(int[] big, int startIndex, CountedLookup countedLookup) {
		int index = startIndex;
		
		/* Move forward until everything is fulfilled. */
		while (!countedLookup.areAllFulfilled() && index + 1 < big.length) {
			index++;
			countedLookup.incrementIfFound(big[index]);
		}
		return index;	
	}	
	
	public static void main(String[] args) {
		int[] array = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
		int[] set = {1, 5, 9};
		Range shortest = shortestSupersequence(array, set);
		if (shortest == null) {
			System.out.println("not found");
		} else {
			System.out.println(shortest.toString());
			for (int i = shortest.getStart(); i <= shortest.getEnd(); i++) {
				System.out.print(array[i] + ", ");
			}
		}
	}

}
