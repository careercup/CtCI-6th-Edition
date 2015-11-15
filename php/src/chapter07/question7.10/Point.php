<?php

class Point {
    private $row;
    private $column;

    public function __construct($row, $column) {
        $this->row = $row;
        $this->column = $column;
    }

    public function getRow() {
        return $this->row;
    }

    public function getColumn() {
        return $this->column;
    }

    public function __toString() {
        return $this->row . ',' . $this->column;
    }
}