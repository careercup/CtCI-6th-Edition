<?php
require_once __DIR__ . '/../../../src/chapter03/question3.3/RandomAccessSizedStack.php';

class RandomAccessSizedStackTest extends PHPUnit_Framework_TestCase {

    public function testRandomAccessSizedStack() {
        $stack = new RandomAccessSizedStack();
        $this->assertEquals(0, $stack->getSize());
        $this->assertNull($stack->peek());
        $this->assertNull($stack->pop());

        $stack->push("one");
        $this->assertEquals(1, $stack->getSize());
        $this->assertEquals("one", $stack->peek());
        $this->assertEquals("one", $stack->peekAt(0));
        $this->assertEquals("one", $stack->pop());
        $this->assertEquals(0, $stack->getSize());

        $stack->push("one");
        $stack->push("two");
        $stack->push("three");
        $stack->push("four");
        $this->assertEquals(4, $stack->getSize());

        $this->assertEquals("one", $stack->peekAt(0));
        $this->assertEquals("two", $stack->peekAt(1));
        $this->assertEquals("three", $stack->peekAt(2));
        $this->assertEquals("four", $stack->peekAt(3));
    }

    public function testIndexOutOfBounds() {
        $stack = new RandomAccessSizedStack();
        $this->setExpectedException('InvalidArgumentException');
        $stack->peekAt(0);
    }
}