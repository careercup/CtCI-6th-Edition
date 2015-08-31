<?php
require_once __DIR__ . '/../../lib/Node.php';

class SizedStack {
    protected $linkedList;
    protected $size = 0;

    public function push($value) {
        $newHead = new Node($value);
        $newHead->setNext($this->linkedList);
        $this->linkedList = $newHead;
        $this->size++;
    }

    public function pop() {
        if ($this->linkedList === null) {
            return null;
        }
        $top = $this->linkedList;
        $this->linkedList = $this->linkedList->getNext();
        $this->size--;
        return $top->getData();
    }

    public function peek() {
        if ($this->linkedList === null) {
            return null;
        }
        return $this->linkedList->getData();
    }

    public function getSize() {
        return $this->size;
    }
}
