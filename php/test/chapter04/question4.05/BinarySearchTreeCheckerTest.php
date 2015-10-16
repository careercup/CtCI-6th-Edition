<?php
require_once __DIR__ . '/../../../src/chapter04/question4.05/BinarySearchTreeChecker.php';

class BinarySearchTreeCheckerTest extends PHPUnit_Framework_TestCase {
    public function testIsBinarySearchTree() {
        $n1 = new BinaryTreeNode(1);
        $n2 = new BinaryTreeNode(2);
        $n3 = new BinaryTreeNode(3);
        $n4 = new BinaryTreeNode(4);
        $n5 = new BinaryTreeNode(5);
        $n6 = new BinaryTreeNode(6);
        $n7 = new BinaryTreeNode(7);
        $n8 = new BinaryTreeNode(8);
        $n9 = new BinaryTreeNode(9);
        $n10 = new BinaryTreeNode(10);
        $n11 = new BinaryTreeNode(11);
        $n12 = new BinaryTreeNode(12);
        $n13 = new BinaryTreeNode(13);
        $n14 = new BinaryTreeNode(14);
        $n15 = new BinaryTreeNode(15);
        $n16 = new BinaryTreeNode(16);

        $n8->setLeft($n4);
        $n8->setRight($n12);
        $this->assertTrue(BinarySearchTreeChecker::isBinarySearchTree($n8));
        $n4->setLeft($n2);
        $n4->setRight($n6);
        $this->assertTrue(BinarySearchTreeChecker::isBinarySearchTree($n8));
        $n12->setLeft($n10);
        $n12->setRight($n14);
        $this->assertTrue(BinarySearchTreeChecker::isBinarySearchTree($n8));

        $n2->setLeft($n16);
        $this->assertFalse(BinarySearchTreeChecker::isBinarySearchTree($n8));
        $n2->setLeft($n1);
        $this->assertTrue(BinarySearchTreeChecker::isBinarySearchTree($n8));
        $n2->setRight($n15);
        $this->assertFalse(BinarySearchTreeChecker::isBinarySearchTree($n8));
        $n2->setRight($n3);
        $this->assertTrue(BinarySearchTreeChecker::isBinarySearchTree($n8));
        $n10->setRight($n9);
        $this->assertFalse(BinarySearchTreeChecker::isBinarySearchTree($n8));
        $n10->setRight($n11);
        $this->assertTrue(BinarySearchTreeChecker::isBinarySearchTree($n8));
        $n14->setLeft($n5);
        $this->assertFalse(BinarySearchTreeChecker::isBinarySearchTree($n8));
        $n14->setLeft($n13);
        $this->assertTrue(BinarySearchTreeChecker::isBinarySearchTree($n8));
        $n6->setLeft($n5);
        $n6->setRight($n7);
        $this->assertTrue(BinarySearchTreeChecker::isBinarySearchTree($n8));
    }
}
