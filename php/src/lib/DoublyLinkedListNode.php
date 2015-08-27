<?php
require_once __DIR__ . DIRECTORY_SEPARATOR . 'Node.php';

class DoublyLinkedListNode extends Node {
    private $previous;

    public function getPrevious() {
        return $this->previous;
    }

    public function setPrevious($node) {
        $this->previous = $node;
    }
}