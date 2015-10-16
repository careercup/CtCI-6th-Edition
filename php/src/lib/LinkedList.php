<?php
require_once __DIR__ . DIRECTORY_SEPARATOR . 'DoublyLinkedListNode.php';

class LinkedList implements Iterator {
    private $head;
    private $tail;
    private $current;
    private $key;
    private $size;

    public function __construct() {
        $this->head = $this->tail = $this->current = null;
        $this->key = 0;
        $this->size = 0;
    }

    public function add($data) {
        $node = new DoublyLinkedListNode($data);
        if ($this->head === null) {
            $this->head = $this->tail = $node;
        } else {
            $this->tail->setNext($node);
            $node->setPrevious($this->tail);
            $this->tail = $node;
        }
        $this->size++;
    }

    public function removeFirst() {
        if ($this->head === null) {
            return null;
        }
        $data = $this->head->getData();
        $this->head = $this->head->getNext();
        if ($this->head !== null) {
            $this->head->setPrevious(null);
        } else {
            $this->tail = null;
        }
        $this->size--;
        return $data;
    }

    public function removeLast() {
        if ($this->tail === null) {
            return null;
        }
        $data = $this->tail->getData();
        $this->tail = $this->tail->getPrevious();
        if ($this->tail !== null) {
            $this->tail->setNext(null);
        } else {
            $this->head = null;
        }
        $this->size--;
        return $data;
    }

    public function peekFirst() {
        if ($this->head === null) {
            return null;
        }
        return $this->head->getData();
    }

    public function peekLast() {
        if ($this->tail === null) {
            return null;
        }
        return $this->tail->getData();
    }

    public function getSize() {
        return $this->size;
    }

    public function isEmpty() {
        return $this->size == 0 ? true : false;
    }

    // Methods of the Iterator interface - http://php.net/manual/en/class.iterator.php

    public function current() {
        if ($this->current === null) {
            return null;
        }
        return $this->current->getData();
    }

    public function key() {
        return $this->key;
    }

    public function next() {
        if ($this->current === null) {
            return;
        }
        $this->current = $this->current->getNext();
        if ($this->current !== null) {
            $this->key++;
        } else {
            $this->key = 0;
        }
    }

    public function rewind() {
        $this->current = $this->head;
        $this->key = 0;
    }

    public function valid() {
        return $this->current !== null ? true : false;
    }
}