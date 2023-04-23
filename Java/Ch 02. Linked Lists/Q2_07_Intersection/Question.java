package Q2_07_Intersection;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Question {

	public static class Result {
		public LinkedListNode tail;
		public int size;
		public Result(LinkedListNode tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}
	
	public static Result getTailAndSize(LinkedListNode list) {
		if (list == null) return null;
		
		int size = 1;
		LinkedListNode current = list;
		while (current.next != null) {
			size++;
			current = current.next;
		}
		return new Result(current, size);
	}
	
	public static LinkedListNode getKthNode(LinkedListNode head, int k) {
		LinkedListNode current = head;
		while (k > 0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
	}
	
	public static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
		if (list1 == null || list2 == null) return null;
		
		/* Get tail and sizes. */
		Result result1 = getTailAndSize(list1);
		Result result2 = getTailAndSize(list2);
		
		/* If different tail nodes, then there's no intersection. */
		if (result1.tail != result2.tail) {
			return null;
		}
		
		/* Set pointers to the start of each linked list. */
		LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
		LinkedListNode longer = result1.size < result2.size ? list2 : list1;
		
		/* Advance the pointer for the longer linked list by the difference in lengths. */
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));
		
		/* Move both pointers until you have a collision. */
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		
		/* Return either one. */
		return longer; 
	}
	
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
		LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);
		
		int[] vals2 = {12, 14, 15};
		LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);
		
		list2.next.next = list1.next.next.next.next;
		
		System.out.println(list1.printForward());
		System.out.println(list2.printForward());
		
		
		LinkedListNode intersection = findIntersection(list1, list2);
		
		System.out.println(intersection.printForward());
	}

}
