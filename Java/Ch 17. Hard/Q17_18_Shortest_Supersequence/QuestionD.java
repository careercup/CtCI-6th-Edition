package Q17_18_Shortest_Supersequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import CtCILibrary.HashMapList;

public class QuestionD {

	public static Range getShortestClosure(ArrayList<Queue<Integer>> lists) {
		PriorityQueue<HeapNode> minHeap = new PriorityQueue<HeapNode>();
		int max = Integer.MIN_VALUE;
		
		/* Insert min element from each list. */ 
		for (int i = 0; i < lists.size(); i++) {
			Queue<Integer> list = lists.get(i);
			if (list == null || list.size() == 0) {
				return null;
			}
			int head = list.remove();
			minHeap.add(new HeapNode(head, i));
			max = Math.max(max, head);
		}
		
		int min = minHeap.peek().locationWithinList;
		int bestRangeMin = min;
		int bestRangeMax = max;
		
		while (true) {
			/* Remove min node. */
			HeapNode n = minHeap.poll();
			Queue<Integer> list = lists.get(n.listId);
			
			/* Compare range to best range. */
			min = n.locationWithinList;
			if (max - min < bestRangeMax - bestRangeMin) {
				bestRangeMax = max;
				bestRangeMin = min;
			}
			
			/* If there are no more elements, then there's no more subsequences and we can break. */
			if (list.size() == 0) {
				break;
			}			
			
			/* Add new head of list to heap. */
			n.locationWithinList = list.remove();
			minHeap.add(n);
			max = Math.max(max, n.locationWithinList);
		}
		
		return new Range(bestRangeMin, bestRangeMax);
	}
	
	/* Get list of queues (linked lists) storing the indices at which
	 * each element in smallArray appears in bigArray. */
	public static ArrayList<Queue<Integer>> getLocationsForElements(int[] big, int[] small) {
		/* Initialize hash map from item value to locations. */
		HashMap<Integer, Queue<Integer>> itemLocations = new HashMap<Integer, Queue<Integer>>();
		for (int s : small) {
			Queue<Integer> queue = new LinkedList<Integer>();
			itemLocations.put(s, queue);
		}
		
		/* Walk through big array, adding the item locations to hash map */
		for (int i = 0; i < big.length; i++) {
			Queue<Integer> queue = itemLocations.get(big[i]);
			if (queue != null) {
				queue.add(i);
			}
		}
		
		ArrayList<Queue<Integer>> allLocations = new ArrayList<Queue<Integer>>();
		allLocations.addAll(itemLocations.values());
		return allLocations;
	}
	
	public static Range shortestSupersequence(int[] big, int[] small) {
		ArrayList<Queue<Integer>> locations = getLocationsForElements(big, small);
		if (locations == null) return null;
		return getShortestClosure(locations);
	}
	
	public static void main(String[] args) {
		int[] array = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
		int[] set = {1, 5, 9};
		System.out.println(array.length);
		Range shortest = shortestSupersequence(array, set);
		if (shortest == null) {
			System.out.println("not found");
		} else {
			System.out.println(shortest.getStart() + ", " + shortest.getEnd());
		}
	}

}
