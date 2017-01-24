package Q2_06_Palindrome;

import CtCILibrary.LinkedListNode;

import static org.junit.Assert.*;

/**
 * Created by mgobaco on 1/23/17.
 */
public class QuestionCTest {

    @org.junit.Test
    public void testIsPalindromeRecurse() throws Exception {

    }

    @org.junit.Test
    public void testLengthOfList() throws Exception {

    }

    @org.junit.Test
    public void testIsPalindrome() throws Exception {


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
        assertEquals(true, QuestionC.isPalindrome(head));
    }
}