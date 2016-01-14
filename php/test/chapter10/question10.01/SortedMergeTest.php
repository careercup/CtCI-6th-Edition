<?php
require_once __DIR__ . '/../../../src/chapter10/question10.01/SortedMerge.php';

class SortedMergeTest extends PHPUnit_Framework_TestCase {

    public function testMerge1() {
        $a = [ 1, 3, 5, null, null, null ];
        $b = [ 2, 4, 6 ];
        SortedMerge::merge($a, $b);
        $expected = [ 1, 2, 3, 4, 5, 6 ];
        $this->assertEquals($expected, $a);
    }

    public function testMerge2() {
        $a = [ 10, 20, 30, null, null, null ];
        $b = [ 40, 50, 60 ];
        SortedMerge::merge($a, $b);
        $expected = [ 10, 20, 30, 40, 50, 60 ];
        $this->assertEquals($expected, $a);
    }

    public function testMerge3() {
        $a = [ 44, 55, 66, null, null, null ];
        $b = [ 11, 22, 33 ];
        SortedMerge::merge($a, $b);
        $expected = [ 11, 22, 33, 44, 55, 66 ];
        $this->assertEquals($expected, $a);
    }

    public function testMerge4() {
        $a = [ 100, null, null, null ];
        $b = [ 99, 101, 102 ];
        SortedMerge::merge($a, $b);
        $expected = [ 99, 100, 101, 102 ];
        $this->assertEquals($expected, $a);
    }

    public function testMerge5() {
        $a = [ 100, null, null, null ];
        $b = [ 99, 100, 101 ];
        SortedMerge::merge($a, $b);
        $expected = [ 99, 100, 100, 101 ];
        $this->assertEquals($expected, $a);
    }

    public function testMerge6() {
        $a = [ 2, 3, 4, 5, 6, 8, 10, 100, null, null, null, null, null, null ];
        $b = [ 1, 4, 6, 7, 7, 7 ];
        SortedMerge::merge($a, $b);
        $expected = [ 1, 2, 3, 4, 4, 5, 6, 6, 7, 7, 7, 8, 10, 100 ];
        $this->assertEquals($expected, $a);
    }

    public function testInvalidArraySizes() {
        $this->setExpectedException('InvalidArgumentException');
        $a = [ 1, 3, 5, null, null, null ];
        $b = [ 2, 4, 6, 8, 10, 12, 14 ];
        SortedMerge::merge($a, $b);
    }
}
