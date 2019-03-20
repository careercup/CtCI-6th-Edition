package Q2_07_Intersection;

import static Q2_08_Loop_Detection.Question.FindBeginning;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class QuestionA {

  public static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
    if (list1 == null || list2 == null) {
      return null;
    }

    //let's join list1 tail to list2 head and see if there is circular ref
    //if there is then find node where the loop starts and
    // that's the intersection point

    //find list1 tail
    LinkedListNode list1Tail = list1;
    while (list1Tail.next != null) {
      list1Tail = list1Tail.next;
    }

    //join to list2 head
    list1Tail.next = list2;

    LinkedListNode result = FindBeginning(list1);
    list1Tail.next = null;
    return result;
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
