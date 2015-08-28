<?php
$baseDir = __DIR__ . '/../../../src/chapter02/question2.8';
require_once $baseDir . '/LinkedListCycleDetector.php';

class LinkedListCycleDetectorTest extends PHPUnit_Framework_TestCase {

    public function testGetIntersectingNode() {
        $n1 = new Node("one");
        $n2 = new Node("two");
        $n3 = new Node("three");
        $n4 = new Node("four");
        $n5 = new Node("five");

        $n1->setNext($n2);
        $n2->setNext($n3);
        $n3->setNext($n4);
        $n4->setNext($n5);

        $this->assertNull(LinkedListCycleDetector::getCycleNode($n1));

        // create a cycle
        $n5->setNext($n3);

        $this->assertSame($n3, LinkedListCycleDetector::getCycleNode($n1));
    }
}
