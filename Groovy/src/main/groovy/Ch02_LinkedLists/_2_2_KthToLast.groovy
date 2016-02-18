package Ch02_LinkedLists

import Ch02_LinkedLists.utils.Node

/** Return the kth element to last element from a linked list */
class _2_2_KthToLast {
    static getKthToLast(Node head, int reverseIndex) {
        def withSize = getKthToLast_withSize(head, reverseIndex)
        def withIterators = getKthToLast_withIterators(head, reverseIndex)

        assert withSize == withIterators

        withSize
    }

    /** Complexity: O(size) - uses the Node's iterator for size and indexing */
    static getKthToLast_withSize(Node head, int reverseIndex) {
        head[head.size() - reverseIndex]
    }

    /** Complexity: O(size) - uses the Node's iterator for indexing */
    static getKthToLast_withIterators(Node head, int reverseIndex) {
        head[reverseIndex].each { head = head.next }
        head
    }
}