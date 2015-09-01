<?php
require_once __DIR__ . '/../../../src/chapter03/question3.4/MyQueue.php';

class MyQueueTest extends PHPUnit_Framework_TestCase {

    public function testMyQueue() {
        $myQueue = new MyQueue();
        $this->assertNull($myQueue->dequeue());
        $myQueue->enqueue('one');
        $myQueue->enqueue('two');
        $myQueue->enqueue('three');
        $myQueue->enqueue('four');
        $this->assertEquals('one', $myQueue->dequeue());
        $this->assertEquals('two', $myQueue->dequeue());
        $this->assertEquals('three', $myQueue->dequeue());
        $this->assertEquals('four', $myQueue->dequeue());
        $this->assertNull($myQueue->dequeue());
    }
}
