<?php
require_once __DIR__ . '/../../../src/chapter03/question3.5/StackSorter.php';

class StackSorterTest extends PHPUnit_Framework_TestCase {

    public function testSort() {
        $stack = [];
        array_push($stack, "b");
        array_push($stack, "a");
        array_push($stack, "f");
        array_push($stack, "e");
        array_push($stack, "d");
        array_push($stack, "c");
        StackSorter::sort($stack);
        $this->assertEquals("a", array_pop($stack));
        $this->assertEquals("b", array_pop($stack));
        $this->assertEquals("c", array_pop($stack));
        $this->assertEquals("d", array_pop($stack));
        $this->assertEquals("e", array_pop($stack));
        $this->assertEquals("f", array_pop($stack));
        $this->assertTrue(empty($stack));
    }

    public function testSortWithDups() {
        $stack = [];
        array_push($stack, "a");
        array_push($stack, "c");
        array_push($stack, "d");
        array_push($stack, "b");
        array_push($stack, "c");
        array_push($stack, "d");
        StackSorter::sort($stack);
        $this->assertEquals("a", array_pop($stack));
        $this->assertEquals("b", array_pop($stack));
        $this->assertEquals("c", array_pop($stack));
        $this->assertEquals("c", array_pop($stack));
        $this->assertEquals("d", array_pop($stack));
        $this->assertEquals("d", array_pop($stack));
        $this->assertTrue(empty($stack));
    }

    public function testSortEmpty() {
        $stack = [];
        StackSorter::sort($stack);
        $this->assertTrue(empty($stack));
    }
}
