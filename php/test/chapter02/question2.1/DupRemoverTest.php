<?php
$baseDir = __DIR__ . '/../../../src/chapter02/question2.1';
require_once $baseDir . '/HashTableDupRemover.php';
require_once $baseDir . '/DoublePointerDupRemover.php';
require_once $baseDir . '/BackwardScanningDupRemover.php';

class DupRemoverTest extends PHPUnit_Framework_TestCase {
    protected $linkedList;
    protected $values;
    protected $uniqueValues;

    protected function setUp() {
        $this->values = [ 80, 55, 73, 55, 1, 6, 73, 55 ];
        $this->uniqueValues = [ 80, 55, 73, 1, 6 ];
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
        $this->uniqueValues = null;
    }

    public function testHashTableDupRemover() {
        HashTableDupRemover::removeDups($this->linkedList);
        $node = $this->linkedList;
        foreach ($this->uniqueValues as $expectedValue) {
            $this->assertEquals($expectedValue, $node->getData());
            $node = $node->getNext();
        }
        $this->assertNull($node);
    }

    public function testDoublePointerDupRemover() {
        DoublePointerDupRemover::removeDups($this->linkedList);
        $node = $this->linkedList;
        foreach ($this->uniqueValues as $expectedValue) {
            $this->assertEquals($expectedValue, $node->getData());
            $node = $node->getNext();
        }
        $this->assertNull($node);
    }

    public function testBackwardScanningDupRemover() {
        BackwardScanningDupRemover::removeDups($this->linkedList);
        $node = $this->linkedList;
        foreach ($this->uniqueValues as $expectedValue) {
            $this->assertEquals($expectedValue, $node->getData());
            $node = $node->getNext();
        }
        $this->assertNull($node);
    }
}
