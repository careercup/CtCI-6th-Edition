<?php
require_once __DIR__ . '/../../../src/chapter04/question4.09/BinarySearchTreeSequenceCalculator.php';

class BinarySearchTreeSequenceCalculatorTest extends PHPUnit_Framework_TestCase {

    public function testGetSequencesWithThreeNodes() {
        $n1 = new BinaryTreeNode(1);
        $n2 = new BinaryTreeNode(2);
        $n3 = new BinaryTreeNode(3);

        $n2->setLeft($n1);
        $n2->setRight($n3);

        $expected = [
            [ 2, 1, 3 ],
            [ 2, 3, 1 ]
        ];
        $this->assertEquals($expected, BinarySearchTreeSequenceCalculator::getSequences($n2));
    }

    public function testGetSequencesWithFourNodes() {
        $n1 = new BinaryTreeNode(1);
        $n2 = new BinaryTreeNode(2);
        $n3 = new BinaryTreeNode(3);
        $n4 = new BinaryTreeNode(4);

        $n2->setLeft($n1);
        $n2->setRight($n3);

        $n3->setLeft($n4);

        $expected = [
            [ 2, 1, 3, 4 ],
            [ 2, 3, 1, 4 ],
            [ 2, 3, 4, 1 ],
            [ 2, 1, 4, 3 ],
            [ 2, 4, 1, 3 ],
            [ 2, 4, 3, 1 ]
        ];
        $this->assertEquals($expected, BinarySearchTreeSequenceCalculator::getSequences($n2));
    }

    public function testGetSequencesWithFiveNodes() {
        $n1 = new BinaryTreeNode(1);
        $n2 = new BinaryTreeNode(2);
        $n3 = new BinaryTreeNode(3);
        $n4 = new BinaryTreeNode(4);
        $n5 = new BinaryTreeNode(5);

        $n2->setLeft($n1);
        $n2->setRight($n3);

        $n3->setLeft($n4);

        $n4->setRight($n5);

        $expected = [
            [ 2, 1, 3, 4, 5 ],
            [ 2, 3, 1, 4, 5 ],
            [ 2, 3, 4, 1, 5 ],
            [ 2, 3, 4, 5, 1 ],
            [ 2, 1, 4, 3, 5 ],
            [ 2, 4, 1, 3, 5 ],
            [ 2, 4, 3, 1, 5 ],
            [ 2, 4, 3, 5, 1 ],
            [ 2, 1, 4, 5, 3 ],
            [ 2, 4, 1, 5, 3 ],
            [ 2, 4, 5, 1, 3 ],
            [ 2, 4, 5, 3, 1 ],
            [ 2, 1, 3, 5, 4 ],
            [ 2, 3, 1, 5, 4 ],
            [ 2, 3, 5, 1, 4 ],
            [ 2, 3, 5, 4, 1 ],
            [ 2, 1, 5, 3, 4 ],
            [ 2, 5, 1, 3, 4 ],
            [ 2, 5, 3, 1, 4 ],
            [ 2, 5, 3, 4, 1 ],
            [ 2, 1, 5, 4, 3 ],
            [ 2, 5, 1, 4, 3 ],
            [ 2, 5, 4, 1, 3 ],
            [ 2, 5, 4, 3, 1 ]
        ];
        $this->assertEquals($expected, BinarySearchTreeSequenceCalculator::getSequences($n2));
    }

    public function testGetAllOrderingsForSingleElementArray() {
        $input = [1];
        $expected = [[1]];
        $this->assertEquals($expected, BinarySearchTreeSequenceCalculator::getAllOrderings($input));
    }

    public function testGetAllOrderingsForTwoElementArray() {
        $input = [1, 2];
        $expected = [[1, 2], [2, 1]];
        $this->assertEquals($expected, BinarySearchTreeSequenceCalculator::getAllOrderings($input));
    }

    public function testGetAllOrderingsForThreeElementArray() {
        $input = [1, 2, 3];
        $expected = [[1, 2, 3], [2, 1, 3], [2, 3, 1], [1, 3, 2], [3, 1, 2], [3, 2, 1]];
        $this->assertEquals($expected, BinarySearchTreeSequenceCalculator::getAllOrderings($input));
    }
}
