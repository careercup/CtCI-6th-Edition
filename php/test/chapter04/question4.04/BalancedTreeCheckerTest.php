<?php
require_once __DIR__ . '/../../../src/chapter04/question4.04/BalancedTreeChecker.php';

class BalancedTreeCheckerTest extends PHPUnit_Framework_TestCase {

    public function testIsBalanced() {
        $n1 = new BinaryTreeNode("one");
        $n2 = new BinaryTreeNode("two");
        $n3 = new BinaryTreeNode("three");
        $n4 = new BinaryTreeNode("four");
        $n5 = new BinaryTreeNode("five");
        $n6 = new BinaryTreeNode("six");
        $n7 = new BinaryTreeNode("seven");
        $n8 = new BinaryTreeNode("eight");
        $n9 = new BinaryTreeNode("nine");
        $n10 = new BinaryTreeNode("ten");
        $n11 = new BinaryTreeNode("eleven");
        $n12 = new BinaryTreeNode("twelve");
        $n13 = new BinaryTreeNode("thirteen");
        $n14 = new BinaryTreeNode("fourteen");
        $n15 = new BinaryTreeNode("fifteen");
        $n16 = new BinaryTreeNode("sixteen");

        $n1->setLeft($n2);
        $this->assertTrue(BalancedTreeChecker::isBalanced($n1));
        $n1->setRight($n3);
        $this->assertTrue(BalancedTreeChecker::isBalanced($n1));
        $n2->setLeft($n4);
        $this->assertTrue(BalancedTreeChecker::isBalanced($n1));
        $n2->setRight($n5);
        $this->assertTrue(BalancedTreeChecker::isBalanced($n1));
        $n3->setLeft($n6);
        $n3->setRight($n7);
        $this->assertTrue(BalancedTreeChecker::isBalanced($n1));
        $n6->setLeft($n8);
        $n8->setLeft($n9);
        $this->assertFalse(BalancedTreeChecker::isBalanced($n1));
        $n6->setRight($n10);
        $this->assertFalse(BalancedTreeChecker::isBalanced($n1));
        $n10->setLeft($n11);
        $this->assertFalse(BalancedTreeChecker::isBalanced($n1));
        $n4->setLeft($n12);
        $n4->setRight($n13);
        $this->assertFalse(BalancedTreeChecker::isBalanced($n1));
        $n5->setLeft($n14);
        $n5->setRight($n15);
        $this->assertFalse(BalancedTreeChecker::isBalanced($n1));
        $n7->setLeft($n16);
        $this->assertTrue(BalancedTreeChecker::isBalanced($n1));
    }
}
