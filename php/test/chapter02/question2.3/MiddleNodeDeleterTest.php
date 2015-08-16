<?php
$baseDir = __DIR__ . '/../../../src/chapter02/question2.3';
require_once $baseDir . '/MiddleNodeDeleter.php';

class MiddleNodeDeleterTest extends PHPUnit_Framework_TestCase {
    protected $linkedList;
    protected $values;
    protected $expectedValues;
    protected $nodeNinetyNine;

    protected function setUp() {
        $this->values =         [ 16, 22, 4, 19, 99, 17, 44, 90 ];
        $this->expectedValues = [ 16, 22, 4, 19,     17, 44, 90 ];
        // build a linked list
        $head = null;
        $previousNode = null;
        foreach ($this->values as $value) {
            $node = new Node($value);
            if ($value == 99) {
                $this->nodeNinetyNine = $node;
            }
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
        $this->expectedValues = null;
        $this->nodeNinetyNine = null;
    }

    public function testDeleteNodeFromLinkedList() {
        MiddleNodeDeleter::deleteNodeFromLinkedList($this->nodeNinetyNine);
        $node = $this->linkedList;
        foreach ($this->expectedValues as $expectedValue) {
            $this->assertEquals($expectedValue, $node->getData());
            $node = $node->getNext();
        }
        $this->assertNull($node);
    }
}
