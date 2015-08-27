<?php
$baseDir = __DIR__ . '/../../../src/chapter02/question2.5';
require_once $baseDir . '/SumListNoConvert.php';

class SumListNoConvertTest extends PHPUnit_Framework_TestCase {

    public function testSum() {
        $a1 = new Node(7);
        $a2 = new Node(1);
        $a3 = new Node(6);
        $a1->setNext($a2);
        $a2->setNext($a3);

        $b1 = new Node(5);
        $b2 = new Node(9);
        $b3 = new Node(2);
        $b1->setNext($b2);
        $b2->setNext($b3);

        $node = SumListNoConvert::sum($a1, $b1);
        $this->assertEquals(2, $node->getData());
        $node = $node->getNext();
        $this->assertEquals(1, $node->getData());
        $node = $node->getNext();
        $this->assertEquals(9, $node->getData());
        $node = $node->getNext();
        $this->assertNull($node);
    }

    public function testSum2() {
        $a1 = new Node(7);
        $a2 = new Node(1);
        $a3 = new Node(6);
        $a4 = new Node(9);
        $a5 = new Node(9);
        $a1->setNext($a2);
        $a2->setNext($a3);
        $a3->setNext($a4);
        $a4->setNext($a5);

        $b1 = new Node(5);
        $b2 = new Node(9);
        $b3 = new Node(2);
        $b1->setNext($b2);
        $b2->setNext($b3);

        $results = [
            SumListNoConvert::sum($a1, $b1),
            SumListNoConvert::sum($b1, $a1)
        ];

        foreach ($results as $node) {
            $this->assertEquals(2, $node->getData());
            $node = $node->getNext();
            $this->assertEquals(1, $node->getData());
            $node = $node->getNext();
            $this->assertEquals(9, $node->getData());
            $node = $node->getNext();
            $this->assertEquals(9, $node->getData());
            $node = $node->getNext();
            $this->assertEquals(9, $node->getData());
            $node = $node->getNext();
            $this->assertNull($node);
        }
    }

    public function testSum3() {
        $a1 = new Node(8);
        $a2 = new Node(7);
        $a3 = new Node(9);
        $a1->setNext($a2);
        $a2->setNext($a3);

        $b1 = new Node(5);
        $b2 = new Node(8);
        $b3 = new Node(6);
        $b1->setNext($b2);
        $b2->setNext($b3);

        $node = SumListNoConvert::sum($a1, $b1);
        $this->assertEquals(3, $node->getData());
        $node = $node->getNext();
        $this->assertEquals(6, $node->getData());
        $node = $node->getNext();
        $this->assertEquals(6, $node->getData());
        $node = $node->getNext();
        $this->assertEquals(1, $node->getData());
        $node = $node->getNext();
        $this->assertNull($node);
    }

    public function testSumWithMultipleCarryOperations() {
        $a1 = new Node(1);

        $b1 = new Node(9);
        $b2 = new Node(9);
        $b3 = new Node(9);
        $b4 = new Node(9);
        $b5 = new Node(9);
        $b1->setNext($b2);
        $b2->setNext($b3);
        $b3->setNext($b4);
        $b4->setNext($b5);

        $node = SumListNoConvert::sum($a1, $b1);
        $this->assertEquals(0, $node->getData());
        $node = $node->getNext();
        $this->assertEquals(0, $node->getData());
        $node = $node->getNext();
        $this->assertEquals(0, $node->getData());
        $node = $node->getNext();
        $this->assertEquals(0, $node->getData());
        $node = $node->getNext();
        $this->assertEquals(0, $node->getData());
        $node = $node->getNext();
        $this->assertEquals(1, $node->getData());
        $node = $node->getNext();
        $this->assertNull($node);
    }
}
