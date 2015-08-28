<?php
require_once __DIR__ . '/../../lib/Node.php';

class LinkedListIntersectionChecker {
    public static function getIntersectingNode(Node $list1, Node $list2) {
        $list1Set = [];
        $n1 = $list1;
        while ($n1 !== null) {
            $list1Set[] = $n1;
            $n1 = $n1->getNext();
        }
        $n2 = $list2;
        while ($n2 !== null) {
            if (in_array($n2, $list1Set, true)) {
                return $n2;
            }
            $n2 = $n2->getNext();
        }
        return null;
    }
}
