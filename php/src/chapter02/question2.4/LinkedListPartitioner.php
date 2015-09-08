<?php
require_once __DIR__ . '/../../lib/Node.php';

class LinkedListPartitioner {
    public static function partition(Node $node, $x) {
        $head = $node;
        $previousNode = null;
        while ($node !== null) {
            if ($node->getData() < $x && $previousNode !== null) {
                // remove the node from this part of the list
                $previousNode->setNext($node->getNext());
                // put this node at the begining of the list
                $node->setNext($head);
                // reset head
                $head = $node;
                // reset node for the next iteration
                $node = $previousNode;
            } else {
                $previousNode = $node;
                $node = $node->getNext();
            }
        }
        return $head;
    }
}