package Q2_04_Partition;

import CtCILibrary.LinkedListNode;

public class QuestionD {
	public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode current = head.next;
        LinkedListNode insert = head;
        LinkedListNode prev = null;
        LinkedListNode tempHead = null;
        boolean startsWithLarger = false;
        
        if (head.data > x) {
            tempHead = new LinkedListNode(-999, head, null);
            current = tempHead.next;
            insert = tempHead;
            startsWithLarger = true;
        }
        
        while (current != null) {
            if (current.data < x) {
                if (insert != current.prev) {
                    prev = current.prev;
                    prev.next = current.next;
                    
                    current.prev = insert;
                    current.next = insert.next;
                    
                    insert.next = current;
                    insert = current;
                    
                    current = prev.next; 
                    if (current != null) {
                        current.prev = prev;
                    }
                } else {
                    prev = current;
                    insert = current;
                    current = current.next;
                }
            } else {
                prev = current;
                current = current.next;
            }
        }
        
        if (!startsWithLarger) {
            return node;
        } else {
            return tempHead.next;
        }
    }
    
	public static void main (String[] args) throws java.lang.Exception {
		// int[] vals = {33,9,2,3,10,10389,838,874578,5};
		int[] vals = {3,5,8,5,10,2,1};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		
		System.out.println(head.printForward());
		
		LinkedListNode result = partition(head, 3);
		
		System.out.println(result.printForward());
	}
}
