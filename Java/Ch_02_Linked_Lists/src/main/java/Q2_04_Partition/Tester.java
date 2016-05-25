package Q2_04_Partition;

import CtCILibrary.LinkedListNode;

public class Tester {
	
	public static LinkedListNode createLinkedList() {
		/* Create linked list */
		int[] vals = {3, 5, 8, 5, 10, 2, 1};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		return head;
	}

	public static void main(String[] args) {
		System.out.println(createLinkedList().printForward());
		
		/* Partition */
		LinkedListNode hA = Question.partition(createLinkedList(), 5);
		LinkedListNode hB = QuestionB.partition(createLinkedList(), 5);
		LinkedListNode hC = QuestionC.partition(createLinkedList(), 5);
		
		/* Print Result */
		System.out.println(hA.printForward());
		System.out.println(hB.printForward());
		System.out.println(hC.printForward());
	}

}
