<?php
require_once __DIR__ . '/../../lib/Node.php';

class LinkedListIntersectionCheckerNoHashMap {
    public static function getIntersectingNode(Node $node1, Node $node2) {
        $list1Size = self::getLinkedListSize($node1);
        $list2Size = self::getLinkedListSize($node2);

        if ($list1Size < $list2Size) {
            do {
                $node2 = $node2->getNext();
                $list2Size--;
            } while ($list1Size < $list2Size);
        } elseif ($list2Size < $list1Size) {
            do {
                $node1 = $node1->getNext();
                $list1Size--;
            } while ($list2Size < $list1Size);
        }
        while ($node1 !== null) {
            if ($node1 === $node2) {
                return $node1;
            }
            $node1 = $node1->getNext();
            $node2 = $node2->getNext();
        }
        return null;
    }

    public static function getLinkedListSize(Node $node) {
        $size = 0;
        while ($node !== null) {
            $size++;
            $node = $node->getNext();
        }
        return $size;
    }
}
