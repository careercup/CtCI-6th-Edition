package Q2_03_Delete_Middle_Node;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Question {

	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false; // Failure
		} 
		LinkedListNode next = n.next; 
		n.data = next.data; 
		n.next = next.next; 
		return true;
	}

	public static LinkedListNode getMiddleNode(LinkedListNode head) {

		if(head == null) {
			return null;
		}

		if(head.next == null) {
			return head;
		} else {
			LinkedListNode slow = head;
			LinkedListNode fast = head;

			while(fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}

			return slow;
		}

	}
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		deleteNode(getMiddleNode(head)); // delete node 4
		System.out.println(head.printForward());
	}

}
