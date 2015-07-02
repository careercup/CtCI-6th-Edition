package Q2_06_Palindrome;

import CtCILibrary.LinkedListNode;

public class QuestionA {
	public static class HeadAndTail {
		public LinkedListNode head;
		public LinkedListNode tail;
		public HeadAndTail(LinkedListNode h, LinkedListNode t) {
			head = h;
			tail = t;
		}
	}
	
	public static HeadAndTail reverse(LinkedListNode head) {
		if (head == null) {
			return null;
		}
		HeadAndTail ht = reverse(head.next);
		LinkedListNode clonedHead = head.clone();
		clonedHead.next = null;
		
		if (ht == null) {
			return new HeadAndTail(clonedHead, clonedHead);
		}
		ht.tail.next = clonedHead;
		return new HeadAndTail(ht.head, clonedHead);
	}
	
	public static boolean isEqual(LinkedListNode one, LinkedListNode two) {
		LinkedListNode head1 = one;
		LinkedListNode head2 = two;
		while (head1 != null && head2 != null) {
			if (head1.data != head2.data) {
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return head1 == null && head2 == null;
	}
	
	public static boolean isPalindrome(LinkedListNode head) {
		HeadAndTail reversed = reverse(head);
		LinkedListNode reversedHead = reversed.head;
		return isEqual(head, reversedHead);
	}
	
	public static void main(String[] args) {
		int length = 9;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}
		
		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		//nodes[length - 2].data = 9; // Uncomment to ruin palindrome
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		System.out.println(isPalindrome(head));
	}

}
