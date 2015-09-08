<?php
require_once __DIR__ . '/../../lib/Node.php';

class MiddleNodeDeleter {
    public static function deleteNodeFromLinkedList(Node $node) {
        if ($node === null) {
            throw new InvalidArgumentException('node is null');
        }
        $next = $node->getNext();
        if ($next === null) {
            throw new InvalidArgumentException('node is not in the middle of a linked list');
        }
        // overwrite values in the deleted node with the ones from the next node.
        $node->setData($next->getData());
        $node->setNext($next->getNext());
    }
}