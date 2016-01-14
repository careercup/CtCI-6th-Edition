<?php
require_once __DIR__ . '/../../../src/chapter07/question7.10/Point.php';

class PointTest extends PHPUnit_Framework_TestCase {

    public function testToString() {
        $point = new Point(3, 5);
        $this->assertEquals('3,5', (string) $point);
    }
}
