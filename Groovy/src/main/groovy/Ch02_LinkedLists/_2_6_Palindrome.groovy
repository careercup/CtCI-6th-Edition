package Ch02_LinkedLists

import Ch02_LinkedLists.utils.Node

import static Ch02_LinkedLists._2_5_SumLists.reverse

/** Return whether a linkedList represents a palindrome */
class _2_6_Palindrome {
    static isPalindrome(Node head) {
        def withReverse = isPalindrome_withStack(head)
        def withStack = isPalindrome_withStack(head)

        assert withReverse == withStack

        withReverse
    }

    /** Complexity: O(size), with same amount of space required */
    static isPalindrome_withReverse(Node head) {
        def (it1, it2) = [head.iterator(), reverse(head).iterator()]
        while (it1.hasNext() && it2.hasNext())
            if (it1.next() != it2.next())
                return false

        it1.hasNext() == it2.hasNext()
    }

    /** Complexity: O(size), with same amount of space required */
    static isPalindrome_withStack(Node head) {
        def (slow, stack) = getFirstHalf(head)

        for (def remaining : slow)
            if (remaining.value != stack.pop())
                return false

        stack.size() <= 1
    }
    static getFirstHalf(Node head) {
        def stack = new ArrayDeque()

        def (slow, fast) = [head.iterator(), head.iterator()]
        while (fast.hasNext()) {
            def next = slow.next()
            fast.next()
            if (fast.hasNext()) {
                stack.push(next.value)
                fast.next()
            }
        }

        [slow, stack]
    }
}