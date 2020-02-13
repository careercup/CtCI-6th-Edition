package Q2_03_Delete_Middle_Node;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class QuestionB {

	public static LinkedListNode deleteMid(LinkedListNode head)  
  {  
      // Base cases  
      if (head == null)  
          return null;  
      if (head.next == null)  
      {  
          return null;  
      } 
      // Initialize slow and fast pointers to reach  
      // middle of linked list  
      LinkedListNode slow_ptr = head;  
      LinkedListNode fast_ptr = head;  

      // Find the middle and previous of middle.  
      LinkedListNode prev = null;  

      // To store previous of slow_ptr  
      while (fast_ptr != null && fast_ptr.next != null)  
      {  
          fast_ptr = fast_ptr.next.next;  
          prev = slow_ptr;  
          slow_ptr = slow_ptr.next;  
      }  

      //Delete the middle node  
      prev.next = slow_ptr.next;  

      return head;  
  } 
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		deleteMid(head);
		System.out.println(head.printForward());
	}

}
