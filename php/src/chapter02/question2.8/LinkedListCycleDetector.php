<?php
require_once __DIR__ . '/../../lib/Node.php';

class LinkedListCycleDetector {
    public static function getCycleNode(Node $list) {
        $node1 = $list;
        $node2 = $list;
        while ($node1 !== null) {
            if ($node2 !== null) {
                // skip 1 because this iterator goes twice as fast
                $node2 = $node2->getNext();
                if ($node1 == $node2) {
                    return $node1;
                }
            }
            $node1 = $node1->getNext();
            if ($node2 !== null) {
                $node2 = $node2->getNext();
            }
        }
        return null;
    }
}
