<?php
require_once __DIR__ . '/../../../src/chapter05/question5.1/Insertion.php';

class InsertionTest extends PHPUnit_Framework_TestCase {

    public function testInsert() {
         $n = 0b10000000000;
         $m = 0b10011;
         $i = 2;
         $j = 6;
         $this->assertEquals(0b10001001100, Insertion::insert($n, $m, $i, $j));
    }

    public function testInsertWithClearRequired() {
         $n = 0b10001111100;
         $m = 0b10011;
         $i = 2;
         $j = 6;
         $this->assertEquals(0b10001001100, Insertion::insert($n, $m, $i, $j));
    }
}
