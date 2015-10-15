<?php
require_once __DIR__ . '/../../../src/chapter04/question4.12/PathsWithSumCounter.php';
require_once __DIR__ . '/../../../src/chapter04/question4.12/PathsWithSumCounterBruteForce.php';

class PathsWithSumCounterTest extends PHPUnit_Framework_TestCase {

    public function testCountPaths() {
        $n1 = new BinaryTreeNode(1);
        $n2 = new BinaryTreeNode(1);
        $n3 = new BinaryTreeNode(1);
        $n4 = new BinaryTreeNode(1);
        $n5 = new BinaryTreeNode(1);
        $n6 = new BinaryTreeNode(1);
        $n7 = new BinaryTreeNode(1);

        $n4->setLeft($n2);
        $n4->setRight($n6);

        $n2->setLeft($n1);
        $n2->setRight($n3);

        $n6->setLeft($n5);
        $n6->setRight($n7);

        $this->assertEquals(0, PathsWithSumCounterBruteForce::countPathsWithSum($n4, 4));
        $this->assertEquals(4, PathsWithSumCounterBruteForce::countPathsWithSum($n4, 3));
        $this->assertEquals(6, PathsWithSumCounterBruteForce::countPathsWithSum($n4, 2));
        $this->assertEquals(7, PathsWithSumCounterBruteForce::countPathsWithSum($n4, 1));

        $this->assertEquals(0, PathsWithSumCounter::countPathsWithSum($n4, 4));
        $this->assertEquals(4, PathsWithSumCounter::countPathsWithSum($n4, 3));
        $this->assertEquals(6, PathsWithSumCounter::countPathsWithSum($n4, 2));
        $this->assertEquals(7, PathsWithSumCounter::countPathsWithSum($n4, 1));
    }

    public function testCountPathsMoreInterestingExample() {
        $n1 = new BinaryTreeNode(7);
        $n2 = new BinaryTreeNode(-2);
        $n3 = new BinaryTreeNode(4);
        $n4 = new BinaryTreeNode(1);
        $n5 = new BinaryTreeNode(-3);
        $n6 = new BinaryTreeNode(2);
        $n7 = new BinaryTreeNode(2);
        $n8 = new BinaryTreeNode(5);

        $n4->setLeft($n2);
        $n4->setRight($n6);

        $n2->setLeft($n1);
        $n2->setRight($n3);

        $n6->setLeft($n5);
        $n6->setRight($n7);

        $n5->setRight($n8);

        $this->assertEquals(4, PathsWithSumCounterBruteForce::countPathsWithSum($n4, 5));
        $this->assertEquals(4, PathsWithSumCounter::countPathsWithSum($n4, 5));
    }

    public function testGetPathSumCount() {
        $values = [ 2, 1, -1, 6 ];
        $this->assertEquals(2, PathsWithSumCounterBruteForce::getPathSumCount($values, 6));
    }
}
