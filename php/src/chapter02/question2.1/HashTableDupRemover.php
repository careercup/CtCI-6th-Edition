<?php
require_once __DIR__ . '/../../lib/Node.php';

class HashTableDupRemover {
    public static function removeDups(Node $node) {
        $hashTable = [];
        $previousNode = $node;
        $node = $node !== null ? $node->getNext() : null;
        while ($node !== null) {
            $data = $node->getData();
            if (array_key_exists($data, $hashTable)) {
                // remove the current node from the linked list
                $previousNode->setNext($node->getNext());
                $node = $previousNode;
            } else {
                $hashTable[$data] = $node;
                $previousNode = $node;
            }
            $node = $node->getNext();
        }
    }
}