<?php
require_once __DIR__ . DIRECTORY_SEPARATOR . 'Point.php';

class Move extends Point {
    private $flag;

    public function __construct($row, $column, $flag=false) {
        parent::__construct($row, $column);
        $this->flag = $flag;
    }

    public function isFlag() {
        return $this->flag;
    }

    public function __toString() {
        return ($this->flag ? 'f' : '') . parent::__toString();
    }

    public static function parse($moveString, $maxRow, $maxColumn) {
        $matches = [];
        if (!preg_match('/^\s*([fF]?)\s*(\d+)\s*,\s*(\d+)\s*$/', $moveString, $matches)) {
            throw new InvalidArgumentException('Invalid move: "' . $moveString . '"');
        }
        $flag = ($matches[1] === 'f' || $matches[1] === 'F' ? true : false);
        $row = $matches[2];
        $column = $matches[3];
        if ($row > $maxRow || $column > $maxColumn) {
            throw new InvalidArgumentException('Invalid move: "' . $moveString . '"');
        }
        return new Move($row, $column, $flag);
    }
}