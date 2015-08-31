<?php
require_once __DIR__ . '/../../../src/chapter03/question3.3/SetOfStacks.php';

class SetOfStacksTest extends PHPUnit_Framework_TestCase {

    public function testSetOfStacks() {
        $stack = new SetOfStacks(3);
        $this->assertEquals(0, $stack->getStackCount());
        $this->assertNull($stack->peek());
        $this->assertNull($stack->pop());

        $stack->push("one");
        $this->assertEquals(1, $stack->getStackCount());
        $this->assertEquals("one", $stack->peek());
        $stack->push("two");
        $this->assertEquals("two", $stack->peek());
        $stack->push("three");
        $this->assertEquals(1, $stack->getStackCount());
        $this->assertEquals("three", $stack->peek());

        $stack->push("four");
        $this->assertEquals(2, $stack->getStackCount());
        $stack->push("five");
        $stack->push("six");
        $this->assertEquals(2, $stack->getStackCount());

        $stack->push("seven");
        $this->assertEquals(3, $stack->getStackCount());
        $this->assertEquals("seven", $stack->peek());

        $this->assertEquals("seven", $stack->pop());
        $this->assertEquals(2, $stack->getStackCount());
        $this->assertEquals("six", $stack->pop());
        $this->assertEquals("five", $stack->pop());
        $this->assertEquals(2, $stack->getStackCount());
        $this->assertEquals("four", $stack->pop());
        $this->assertEquals(1, $stack->getStackCount());

        $this->assertEquals("three", $stack->pop());
        $this->assertEquals("two", $stack->pop());
        $this->assertEquals("one", $stack->pop());
        $this->assertEquals(0, $stack->getStackCount());
        $this->assertNull($stack->peek());
    }

    public function testPopAt() {
        $stack = new SetOfStacks(3);
        $this->assertEquals(0, $stack->getStackCount());

        $stack->push("one");
        $this->assertEquals(1, $stack->getStackCount());
        $stack->push("two");
        $stack->push("three");
        $this->assertEquals(1, $stack->getStackCount());
        $stack->push("four");
        $this->assertEquals(2, $stack->getStackCount());
        $stack->push("five");
        $stack->push("six");
        $this->assertEquals(2, $stack->getStackCount());
        $stack->push("seven");
        $this->assertEquals(3, $stack->getStackCount());
        $stack->push("eight");
        $stack->push("nine");
        $this->assertEquals(3, $stack->getStackCount());
        $stack->push("ten");
        $this->assertEquals(4, $stack->getStackCount());
        $stack->push("eleven");
        $stack->push("twelve");
        $this->assertEquals(4, $stack->getStackCount());

        $this->assertEquals("nine", $stack->popAt(2));
        $this->assertEquals("twelve", $stack->peek());
        $this->assertEquals(4, $stack->getStackCount());

        $this->assertEquals("eight", $stack->popAt(2));
        $this->assertEquals("twelve", $stack->peek());
        $this->assertEquals(4, $stack->getStackCount());

        $this->assertEquals("seven", $stack->popAt(2));
        $this->assertEquals("twelve", $stack->peek());
        $this->assertEquals(4, $stack->getStackCount());

        $this->assertNull($stack->popAt(2));
        $this->assertEquals("twelve", $stack->pop());
        $this->assertEquals("eleven", $stack->pop());
        $this->assertEquals(4, $stack->getStackCount());
        $this->assertEquals("ten", $stack->pop());
        $this->assertEquals(2, $stack->getStackCount());
        $this->assertEquals("six", $stack->peek());
        $this->assertEquals(2, $stack->getStackCount());

        $this->assertEquals("three", $stack->popAt(0));
        $this->assertEquals("two", $stack->popAt(0));
        $this->assertEquals("one", $stack->popAt(0));
        $this->assertNull($stack->popAt(0));
        $this->assertEquals(2, $stack->getStackCount());

        $this->assertEquals("six", $stack->pop());
        $this->assertEquals(2, $stack->getStackCount());
        $this->assertEquals("five", $stack->pop());
        $this->assertEquals("four", $stack->pop());
        $this->assertEquals(0, $stack->getStackCount());
        $this->assertNull($stack->peek());
        $this->assertNull($stack->pop());
    }
}
