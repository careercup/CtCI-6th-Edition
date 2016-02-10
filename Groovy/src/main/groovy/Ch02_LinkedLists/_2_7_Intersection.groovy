package Ch02_LinkedLists

import Ch02_LinkedLists.utils.Node

import static java.lang.Math.abs

/** Find the intersecting node of two linked lists */
class _2_7_Intersection {
    static intersection(Node head1, Node head2) {
        (head1, head2) = alignEnds(head1, head2)
        while (head1.isValid())
            if (head1.is(head2)) return head1
            else (head1, head2) = [head1.next, head2.next]

        Node.END_SENTINEL
    }
    static alignEnds(Node head1, Node head2) {
        def (size1, size2) = [head1.size(), head2.size()]
        def index = abs(size1 - size2)
        (size1 > size2) ? [head1[index], head2]
                        : [head1, head2[index]]
    }
}