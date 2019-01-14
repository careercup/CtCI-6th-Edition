package Q2_06_Palindrome;

import CtCILibrary.LinkedListNode;

public class QuestionC {
	public static class Result {
		public LinkedListNode node;
		public boolean result;
		public Result(LinkedListNode n, boolean res) {
			node = n;
			result = res;
		}
	}

	public static Result isPalindromeRecurse(LinkedListNode slow, LinkedListNode fast) {
		if (fast.next == null) { // Odd number of nodes: slow is at the mid element
			return new Result(slow.next, true);
		} else if (fast.next.next == null) { // Even number of nodes: the two mids need comparison
			return new Result(slow.next.next, slow.data == slow.next.data);
		} 
		
		/* Recurse on sublist. */
		Result res = isPalindromeRecurse(slow.next, fast.next.next);
		
		/* If child calls are not a palindrome, pass back up 
		 * a failure. */
		if (!res.result || res.node == null) {
			return res;
		} 
		
		/* Check if matches corresponding node on other side. */
		res.result = (slow.data == res.node.data);
		
		/* Return corresponding node. */
		res.node = res.node.next;
		
		return res;
	}
	
	public static boolean isPalindrome(LinkedListNode head) {
		if (head == null) {
			return true;
		}
		Result p = isPalindromeRecurse(head, head);
		return p.result;
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
