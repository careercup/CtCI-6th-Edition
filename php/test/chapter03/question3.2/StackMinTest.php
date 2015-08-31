<?php
require_once __DIR__ . '/../../../src/chapter03/question3.2/StackMin.php';

class StackMinTest extends PHPUnit_Framework_TestCase {

    public function testPushAndPop() {
        $stack = new StackMin();
        $this->assertNull($stack->pop());
        $stack->push(18);
        $stack->push(60);
        $stack->push(12);
        $this->assertEquals(12, $stack->pop());
        $this->assertEquals(60, $stack->pop());
        $this->assertEquals(18, $stack->pop());
        $this->assertNull($stack->pop());
    }

    public function testMinWithIntegers() {
        $stack = new StackMin();
        $this->assertNull($stack->min());
        $stack->push(18);
        $this->assertEquals(18, $stack->min());
        $stack->push(60);
        $this->assertEquals(18, $stack->min());
        $stack->push(12);
        $this->assertEquals(12, $stack->min());
        $stack->pop();
        $this->assertEquals(18, $stack->min());
        $stack->pop();
        $this->assertEquals(18, $stack->min());
        $stack->pop();
        $this->assertNull($stack->min());
    }

    public function testMinWithStrings() {
        $stack = new StackMin();
        $this->assertNull($stack->min());
        $stack->push('ball');
        $this->assertEquals('ball', $stack->min());
        $stack->push('camera');
        $this->assertEquals('ball', $stack->min());
        $stack->push('apple');
        $this->assertEquals('apple', $stack->min());
        $stack->pop();
        $this->assertEquals('ball', $stack->min());
        $stack->pop();
        $this->assertEquals('ball', $stack->min());
        $stack->pop();
        $this->assertNull($stack->min());
    }
}
