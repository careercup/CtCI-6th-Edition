<?php
require_once __DIR__ . '/../../../src/chapter03/question3.3/SizedStack.php';

class SizedStackTest extends PHPUnit_Framework_TestCase {

    public function testSizedStack() {
        $stack = new SizedStack();
        $this->assertEquals(0, $stack->getSize());
        $this->assertNull($stack->peek());
        $this->assertNull($stack->pop());

        $stack->push("one");
        $this->assertEquals(1, $stack->getSize());
        $this->assertEquals("one", $stack->peek());

        $stack->push("two");
        $this->assertEquals(2, $stack->getSize());
        $this->assertEquals("two", $stack->peek());

        $this->assertEquals("two", $stack->pop());
        $this->assertEquals(1, $stack->getSize());
        $this->assertEquals("one", $stack->peek());

        $this->assertEquals("one", $stack->pop());
        $this->assertEquals(0, $stack->getSize());
        $this->assertNull($stack->peek());
    }
}
