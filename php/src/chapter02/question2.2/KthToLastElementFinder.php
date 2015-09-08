<?php
require_once __DIR__ . '/../../lib/Node.php';

class KthToLastElementFinder {
    public static function find(Node $node, $k) {
        $pointer1 = $node;
        $pointer2 = null;
        $i = 0;
        while ($pointer1 !== null) {
            if (++$i == $k) {
                // start iterating over list with 2nd pointer lagging k elements behind 1st pointer
                $pointer2 = $node;
            } elseif ($pointer2 !== null) {
                $pointer2 = $pointer2->getNext();
            }
            $pointer1 = $pointer1->getNext();
        }
        return $pointer2 !== null ? $pointer2->getData() : null;
    }
}