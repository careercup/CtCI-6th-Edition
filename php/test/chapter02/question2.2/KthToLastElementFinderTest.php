<?php
$baseDir = __DIR__ . '/../../../src/chapter02/question2.2';
require_once $baseDir . '/KthToLastElementFinder.php';

class KthToLastElementFinderTest extends PHPUnit_Framework_TestCase {
    protected $linkedList;
    protected $values;

    protected function setUp() {
        $this->values = [ 16, 22, 4, 19, 99, 17, 44, 90 ];
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

    public function testFind() {
        $this->assertEquals(17, KthToLastElementFinder::find($this->linkedList, 3));
        $this->assertNull(KthToLastElementFinder::find($this->linkedList, 99));
    }
}
