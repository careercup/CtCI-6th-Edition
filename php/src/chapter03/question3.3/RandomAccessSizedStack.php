<?php

class RandomAccessSizedStack {
    private $list;
    private $size;

    public function __construct() {
        $this->list = [];
        $this->size = 0;
    }

    public function push($value) {
        array_push($this->list, $value);
        $this->size++;
    }

    public function pop() {
        if ($this->size <= 0) {
            return null;
        }
        $this->size--;
        return array_pop($this->list);
    }

    public function peek() {
        if ($this->size <= 0) {
            return null;
        }
        return $this->list[count($this->list) - 1];
    }

    public function peekAt($index) {
        if ($index >= $this->size) {
            throw new InvalidArgumentException("index out of bounds");
        }
        return $this->list[$index];
    }

    public function getSize() {
        return $this->size;
    }
}
