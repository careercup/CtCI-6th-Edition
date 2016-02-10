package Ch02_LinkedLists

import Ch02_LinkedLists.utils.Node

/** Remove duplicates from a linked list */
class _2_1_FindDuplicates {
    static removeDuplicates(Node head) {
        def squared = removeDuplicates_Squared(head.copy())
        def linear = removeDuplicates_Linear(head.copy())

        assert squared.toList() == linear.toList()

        linear
    }

    /** Complexity: O(size**2) */
    static removeDuplicates_Squared(Node head) {
        for (def node : head)
            for (def comparand = node.next; comparand.isValid();)
                if (node != comparand) comparand = comparand.next
                else comparand.replace(comparand.next)
        head
    }

    /** Complexity: O(size), but needs same amount of space */
    static removeDuplicates_Linear(Node head) {
        Set seen = []
        for (def node = head; node.isValid();)
            if (seen.add(node.value)) node = node.next
            else node.replace(node.next)
        head
    }
}