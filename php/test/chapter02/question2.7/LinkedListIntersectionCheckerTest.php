<?php
$baseDir = __DIR__ . '/../../../src/chapter02/question2.7';
require_once $baseDir . '/LinkedListIntersectionChecker.php';

class LinkedListIntersectionCheckerTest extends PHPUnit_Framework_TestCase {

    public function testGetIntersectingNode() {
        $a1 = new Node("one");
        $a2 = new Node("two");
        $a3 = new Node("three");
        $a4 = new Node("four");
        $a5 = new Node("five");

        $a1->setNext($a2);
        $a2->setNext($a3);
        $a3->setNext($a4);
        $a4->setNext($a5);

        $b1 = new Node("un");
        $b2 = new Node("deux");
        $b3 = new Node("trois");

        $b1->setNext($b2);
        $b2->setNext($b3);

        $this->assertNull(LinkedListIntersectionChecker::getIntersectingNode($a1, $b1));

        $c1 = new Node("uno");
        $c2 = new Node("dos");
        $c3 = new Node("tres");

        $c1->setNext($c2);
        $c2->setNext($c3);

        $a5->setNext($c1);
        $b3->setNext($c1);

        $this->assertSame($c1, LinkedListIntersectionChecker::getIntersectingNode($a1, $b1));
    }
}
