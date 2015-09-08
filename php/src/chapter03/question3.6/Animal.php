<?php

abstract class Animal {
    private $index;
    private $name;

    public function __construct($name) {
        $this->name = $name;
    }

    public function getIndex() {
        return $this->index;
    }

    public function setIndex($index) {
        $this->index = $index;
    }

    public function getName() {
        return $this->name;
    }

    public function setName($name) {
        $this->name = $name;
    }

    public function __toString() {
        return $this->name . ' the ' . get_class($this);
    }
}
