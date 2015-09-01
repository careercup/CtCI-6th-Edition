<?php

class MyQueue {
    private $main;
    private $temp;

    public function __construct() {
        $this->main = [];
        $this->temp = [];
    }

    public function enqueue($value) {
        while (!empty($this->main)) {
            array_push($this->temp, array_pop($this->main));
        }
        array_push($this->main, $value);
        while (!empty($this->temp)) {
            array_push($this->main, array_pop($this->temp));
        }
    }

    public function dequeue() {
        if (empty($this->main)) {
            return null;
        }
        return array_pop($this->main);
    }
}