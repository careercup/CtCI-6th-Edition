<?php
$baseDir = __DIR__ . '/../../../src/chapter02/question2.4';
require_once $baseDir . '/LinkedListPartitioner.php';

class LinkedListPartitionerTest extends PHPUnit_Framework_TestCase {
    protected $linkedList;
    protected $values;

    protected function setUp() {
        $this->values = [ 3, 5, 8, 5, 10, 2, 1 ];
        // build a linked list
        $head = null;
        $previousNode = null;
        foreach ($this->values as $value) {
            $node = new Node($value);
            if ($head === null) {
                $head = $node;
            } else {
                $previousNode->setNext($node);
            }
            $previousNode = $node;
        }
        $this->linkedList = $head;
    }

    protected function tearDown() {
        $this->linkedList = null;
        $this->values = null;
    }

    public function testPartition() {
        $x = 5;
        $node = LinkedListPartitioner::partition($this->linkedList, $x);
        $beforePartition = true;
        $nodeCount = 0;
        while ($node !== null) {
            $data = $node->getData();
            if ($beforePartition && $data >= $x) {
                $beforePartition = false;
            }
            if ($beforePartition) {
                $this->assertTrue($data < $x);
            } else {
                $this->assertTrue($data >= $x);
            }
            $node = $node->getNext();
            $nodeCount++;
        }
        $this->assertEquals(count($this->values), $nodeCount);
    }
}
