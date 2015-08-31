<?php
require_once __DIR__ . '/../../lib/Node.php';

class StackMin {
    private $linkedList;
    private $min;

    public function __construct() {
        $this->linkedList = null;
        $this->min = null;
    }

    public function push($value) {
        $newHead = new Node($value);
        if ($this->linkedList === null) {
            $this->linkedList = $newHead;
            $this->min = new Node($value);
        } else {
            $newHead->setNext($this->linkedList);
            $this->linkedList = $newHead;
            if ($value < $this->min->getData()) {
                $newMin = new Node($value);
                $newMin->setNext($this->min);
                $this->min = $newMin;
            }
        }
    }

    public function pop() {
        if ($this->linkedList === null) {
            return null;
        }
        $top = $this->linkedList;
        $this->linkedList = $this->linkedList->getNext();
        $value = $top->getData();
        if ($this->min != null && $value === $this->min->getData()) {
            $this->min = $this->min->getNext();
        }
        return $value;
    }

    public function min() {
        if ($this->linkedList === null) {
            return null;
        }
        return $this->min->getData();
    }
}