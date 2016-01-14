<?php

/**
 * Circular Array providing O(1) rotation functionality.
 *
 * Note: The question states that generic types should be
 * used if possible. PHP does not support generic types at this time,
 * although Hack does: http://docs.hhvm.com/manual/en/hack.generics.php
 */
class CircularArray implements Iterator, ArrayAccess, Countable {
    private $data;
    private $size;
    private $current;
    private $offset;

    public function __construct() {
        $this->offset = 0;
        $this->data = func_get_args();
        $this->size = count($this->data);
        $this->rewind();
    }

    public function rotate($delta) {
        if ($this->size == 0) {
            return;
        }
        $this->offset = ($this->offset - $delta) % $this->size;
    }

    private function translate($delta) {
        $translated = $this->offset + $delta;
        if ($this->size > 0) {
            $translated %= $this->size;
            if ($translated < 0) {
                $translated += $this->size;
            }
        }
        return $translated;
    }

    private function isRotated() {
        return $this->offset !== 0;
    }

    /* Methods of Iterator */
    public function current() {
        return $this[$this->current];
    }

    public function key() {
        return $this->current;
    }

    public function next() {
        $this->current++;
    }

    public function rewind() {
        $this->current = 0;
    }

    public function valid() {
        return $this->current < $this->size;
    }

    /* Methods of ArrayAccess */
    public function offsetExists($offset) {
        return is_int($offset) && $offset >= 0 && $offset < $this->size;
    }

    public function offsetGet($offset) {
        return $this->data[self::translate($offset)];
    }

    public function offsetSet($offset=null, $value) {
        if ($offset === null) {
            $offset = $this->size;
        }
        if (!$this->offsetExists($offset)) {
            if ($this->isRotated()) {
                throw new OutOfRangeException("Cannot add new elements to a CircularArray while it's rotated");
            }
            if ($offset !== $this->size) {
                throw new OutOfRangeException("Can only add elements to the end of a CircularArray");
            }
            $this->size++;
        }
        $this->data[self::translate($offset)] = $value;
    }

    public function offsetUnset($offset) {
        if (!$this->offsetExists($offset)) {
            throw new OutOfRangeException('Invalid offset: ' . $offset);
        }
        if ($this->isRotated()) {
            throw new OutOfRangeException("Cannot remove elements from a CircularArray while it's rotated");
        }
        if ($offset !== $this->size - 1) {
            throw new OutOfRangeException("Can only remove the last element of a CircularArray");
        }
        unset($this->data[self::translate($offset)]);
        $this->size--;
    }

    /* Methods of Countable */
    public function count() {
        return $this->size;
    }
}