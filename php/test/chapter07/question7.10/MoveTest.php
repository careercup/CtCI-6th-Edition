<?php
require_once __DIR__ . '/../../../src/chapter07/question7.10/Move.php';

class MoveTest extends PHPUnit_Framework_TestCase {

    public function testToString() {
        $move = new Move(2, 1);
        $this->assertEquals('2,1', (string) $move);
    }

    public function testToStringWithFlag() {
        $move = new Move(4, 2, true);
        $this->assertEquals('f4,2', (string) $move);
    }
}
