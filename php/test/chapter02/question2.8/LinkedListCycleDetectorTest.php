<?php
$baseDir = __DIR__ . '/../../../src/chapter02/question2.8';
require_once $baseDir . '/LinkedListCycleDetector.php';

class LinkedListCycleDetectorTest extends PHPUnit_Framework_TestCase {

    public function testFindBeginningOfCycleWithNoCycle() {
        $n1 = new Node("one");
        $n2 = new Node("two");
        $n3 = new Node("three");
        $n4 = new Node("four");
        $n5 = new Node("five");

        $n1->setNext($n2);
        $n2->setNext($n3);
        $n3->setNext($n4);
        $n4->setNext($n5);

        $this->assertNull(LinkedListCycleDetector::findBeginningOfCycle($n1));
    }

    public function testFindBeginningOfCycleWithCycleFromTwoToFive() {
        $n1 = new Node("one");
        $n2 = new Node("two");
        $n3 = new Node("three");
        $n4 = new Node("four");
        $n5 = new Node("five");

        $n1->setNext($n2);
        $n2->setNext($n3);
        $n3->setNext($n4);
        $n4->setNext($n5);
        // create a cycle
        $n5->setNext($n2);

        $cycleNode = LinkedListCycleDetector::findBeginningOfCycle($n1);
        $this->assertSame($n2, $cycleNode, 'Expected: ' . $n2->getData() . ' Found: ' . $cycleNode->getData());
    }

    public function testFindBeginningOfCycleWithCycleFromThreeToFive() {
        $n1 = new Node("one");
        $n2 = new Node("two");
        $n3 = new Node("three");
        $n4 = new Node("four");
        $n5 = new Node("five");

        $n1->setNext($n2);
        $n2->setNext($n3);
        $n3->setNext($n4);
        $n4->setNext($n5);
        // create a cycle
        $n5->setNext($n3);

        $cycleNode = LinkedListCycleDetector::findBeginningOfCycle($n1);
        $this->assertSame($n3, $cycleNode, 'Expected: ' . $n3->getData() . ' Found: ' . $cycleNode->getData());
    }

    public function testFindBeginningOfCycleWithCycleFromFourToFive() {
        $n1 = new Node("one");
        $n2 = new Node("two");
        $n3 = new Node("three");
        $n4 = new Node("four");
        $n5 = new Node("five");

        $n1->setNext($n2);
        $n2->setNext($n3);
        $n3->setNext($n4);
        $n4->setNext($n5);
        // create a cycle
        $n5->setNext($n4);

        $cycleNode = LinkedListCycleDetector::findBeginningOfCycle($n1);
        $this->assertSame($n4, $cycleNode, 'Expected: ' . $n4->getData() . ' Found: ' . $cycleNode->getData());
    }

    public function testFindBeginningOfCycleWithCycleFromFiveToFive() {
        $n1 = new Node("one");
        $n2 = new Node("two");
        $n3 = new Node("three");
        $n4 = new Node("four");
        $n5 = new Node("five");

        $n1->setNext($n2);
        $n2->setNext($n3);
        $n3->setNext($n4);
        $n4->setNext($n5);
        // create a cycle
        $n5->setNext($n5);

        $cycleNode = LinkedListCycleDetector::findBeginningOfCycle($n1);
        $this->assertSame($n5, $cycleNode, 'Expected: ' . $n5->getData() . ' Found: ' . $cycleNode->getData());
    }

    public function testFindBeginningOfCycleWithCircularListOfSizeOne() {
        $n1 = new Node("one");
        $n1->setNext($n1);
        $cycleNode = LinkedListCycleDetector::findBeginningOfCycle($n1);
        $this->assertSame($n1, $cycleNode, 'Expected: ' . $n1->getData() . ' Found: ' . $cycleNode->getData());
    }

    public function testFindBeginningOfCycleWithCircularListOfSizeTwo() {
        $n1 = new Node("one");
        $n2 = new Node("two");
        $n1->setNext($n2);
        $n2->setNext($n1);
        $cycleNode = LinkedListCycleDetector::findBeginningOfCycle($n1);
        $this->assertSame($n1, $cycleNode, 'Expected: ' . $n1->getData() . ' Found: ' . $cycleNode->getData());
    }

    public function testFindBeginningOfCycleWithCircularListOfSizeThree() {
        $n1 = new Node("one");
        $n2 = new Node("two");
        $n3 = new Node("three");
        $n1->setNext($n2);
        $n2->setNext($n3);
        $n3->setNext($n1);
        $cycleNode = LinkedListCycleDetector::findBeginningOfCycle($n1);
        $this->assertSame($n1, $cycleNode, 'Expected: ' . $n1->getData() . ' Found: ' . $cycleNode->getData());
    }

    public function testFindBeginningOfCycleWithCircularListOfSizeFour() {
        $n1 = new Node("one");
        $n2 = new Node("two");
        $n3 = new Node("three");
        $n4 = new Node("four");
        $n1->setNext($n2);
        $n2->setNext($n3);
        $n3->setNext($n4);
        $n4->setNext($n1);
        $cycleNode = LinkedListCycleDetector::findBeginningOfCycle($n1);
        $this->assertSame($n1, $cycleNode, 'Expected: ' . $n1->getData() . ' Found: ' . $cycleNode->getData());
    }

    public function testFindBeginningOfCycleWithCircularListOfSizeFive() {
        $n1 = new Node("one");
        $n2 = new Node("two");
        $n3 = new Node("three");
        $n4 = new Node("four");
        $n5 = new Node("five");
        $n1->setNext($n2);
        $n2->setNext($n3);
        $n3->setNext($n4);
        $n4->setNext($n5);
        $n5->setNext($n1);
        $cycleNode = LinkedListCycleDetector::findBeginningOfCycle($n1);
        $this->assertSame($n1, $cycleNode, 'Expected: ' . $n1->getData() . ' Found: ' . $cycleNode->getData());
    }
}
