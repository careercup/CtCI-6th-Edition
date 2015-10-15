<?php
require_once __DIR__ . '/../../../src/chapter04/question4.08/FirstCommonAncestorFinder.php';

class FirstCommonAncestorFinderTest extends PHPUnit_Framework_TestCase {

    public function testFindFirstCommonAncestorWithTwoLevelTree() {
        $n1 = new BinaryTreeNode(1);
        $n2 = new BinaryTreeNode(2);
        $n3 = new BinaryTreeNode(3);

        $n2->setLeft($n1);
        $n2->setRight($n3);

        $this->assertSame($n2, FirstCommonAncestorFinder::findFirstCommonAncestor($n2, $n1, $n3));
    }

    public function testFindFirstCommonAncestorWithNodeNotFound() {
        $n1 = new BinaryTreeNode(1);
        $n2 = new BinaryTreeNode(2);
        $n3 = new BinaryTreeNode(3);
        $n99 = new BinaryTreeNode(99);

        $n2->setLeft($n1);
        $n2->setRight($n3);

        $this->assertNull(FirstCommonAncestorFinder::findFirstCommonAncestor($n2, $n1, $n99));
    }

    public function testFindFirstCommonAncestorWithTwoSameNodes() {
        $n1 = new BinaryTreeNode(1);
        $n2 = new BinaryTreeNode(2);
        $n3 = new BinaryTreeNode(3);

        $n2->setLeft($n1);
        $n2->setRight($n3);

        $this->assertSame($n3, FirstCommonAncestorFinder::findFirstCommonAncestor($n2, $n3, $n3));
    }

    public function testFindFirstCommonAncestorWithThreeLevelTreeAndFoundNodesAtBottom() {
        $n1 = new BinaryTreeNode(1);
        $n2 = new BinaryTreeNode(2);
        $n3 = new BinaryTreeNode(3);
        $n4 = new BinaryTreeNode(4);
        $n5 = new BinaryTreeNode(5);
        $n6 = new BinaryTreeNode(6);
        $n7 = new BinaryTreeNode(7);

        $n4->setLeft($n2);
        $n4->setRight($n6);

        $n2->setLeft($n1);
        $n2->setRight($n3);

        $n6->setLeft($n5);
        $n6->setRight($n7);

        $this->assertSame($n4, FirstCommonAncestorFinder::findFirstCommonAncestor($n4, $n1, $n7));
    }

    public function testFindFirstCommonAncestorWithThreeLevelTreeAndFoundNodesAtMiddle() {
        $n1 = new BinaryTreeNode(1);
        $n2 = new BinaryTreeNode(2);
        $n3 = new BinaryTreeNode(3);
        $n4 = new BinaryTreeNode(4);
        $n5 = new BinaryTreeNode(5);
        $n6 = new BinaryTreeNode(6);
        $n7 = new BinaryTreeNode(7);

        $n4->setLeft($n2);
        $n4->setRight($n6);

        $n2->setLeft($n1);
        $n2->setRight($n3);

        $n6->setLeft($n5);
        $n6->setRight($n7);

        $this->assertSame($n4, FirstCommonAncestorFinder::findFirstCommonAncestor($n4, $n2, $n6));
    }

    public function testFindFirstCommonAncestorWithFourLevelTree() {
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

        $n8->setLeft($n4);
        $n8->setRight($n12);

        $n4->setLeft($n2);
        $n4->setRight($n6);

        $n12->setLeft($n10);
        $n12->setRight($n14);

        $n2->setLeft($n1);
        $n2->setRight($n3);

        $n6->setLeft($n5);
        $n6->setRight($n7);

        $n10->setLeft($n9);
        $n10->setRight($n11);

        $n14->setLeft($n13);
        $n14->setRight($n15);

        $this->assertSame($n8, FirstCommonAncestorFinder::findFirstCommonAncestor($n8, $n1, $n15));
        $this->assertSame($n8, FirstCommonAncestorFinder::findFirstCommonAncestor($n8, $n4, $n12));
        $this->assertSame($n4, FirstCommonAncestorFinder::findFirstCommonAncestor($n8, $n2, $n5));
        $this->assertSame($n4, FirstCommonAncestorFinder::findFirstCommonAncestor($n8, $n6, $n1));
        $this->assertSame($n4, FirstCommonAncestorFinder::findFirstCommonAncestor($n8, $n1, $n6));
        $this->assertSame($n4, FirstCommonAncestorFinder::findFirstCommonAncestor($n8, $n1, $n4));
        $this->assertSame($n6, FirstCommonAncestorFinder::findFirstCommonAncestor($n8, $n6, $n7));
    }
}
