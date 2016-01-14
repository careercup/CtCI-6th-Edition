<?php
require_once __DIR__ . '/../../lib/Node.php';

class LinkedListCycleDetector {

    public static function findBeginningOfCycle(Node $list) {
        $node1 = self::getMeetingPoint($list);
        if ($node1 === null) {
            return null;
        }
        // Found the meeting point. Now find the beginning of the cycle
        // by steping towards it at the same pace from the head of the list
        // and the meeting point. When the 2 pointers collide, it will be
        // at the beginning of the cycle.
        $node2 = $list;
        while ($node1 !== $node2) {
            $node1 = $node1->getNext();
            $node2 = $node2->getNext();
        }
        return $node1;
    }

    private static function getMeetingPoint(Node $list) {
        $node1 = $list;
        $node2 = $list;
        while ($node1 !== null) {
            $node1 = $node1->getNext();
            if ($node2 !== null) {
                $node2 = $node2->getNext();
                // skip 1 because this iterator goes twice as fast
                if ($node2 !== null) {
                    $node2 = $node2->getNext();
                    if ($node1 === $node2) {
                        return $node1;
                    }
                }
            }
        }
        return null;
    }
}
