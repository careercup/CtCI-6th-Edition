<?php
require_once __DIR__ . '/../../../src/chapter04/question4.10/SubTreeChecker.php';

class SubTreeCheckerTest extends PHPUnit_Framework_TestCase {

    public function testIsSubTree() {
        $t1n1 = new BinaryTreeNode(1);
        $t1n2 = new BinaryTreeNode(2);
        $t1n3 = new BinaryTreeNode(3);
        $t1n4 = new BinaryTreeNode(5);
        $t1n5 = new BinaryTreeNode(6);

        $t1n1->setLeft($t1n2);
        $t1n1->setRight($t1n3);

        $t1n3->setLeft($t1n4);
        $t1n3->setRight($t1n5);

        $t2n1 = new BinaryTreeNode(3);
        $t2n2 = new BinaryTreeNode(5);
        $t2n3 = new BinaryTreeNode(6);

        $t2n1->setLeft($t2n2);
        $t2n1->setRight($t2n3);

        $this->assertTrue(SubTreeChecker::isSubTree($t1n1, $t2n1));
        $this->assertTrue(SubTreeChecker::isSubTree($t1n1, $t1n1));

        $t3n1 = new BinaryTreeNode(3);
        $t3n2 = new BinaryTreeNode(4);
        $t3n1->setLeft($t3n2);

        $this->assertFalse(SubTreeChecker::isSubTree($t1n1, $t3n1));

        $t3n3 = new BinaryTreeNode(5);
        $t3n1->setRight($t3n3);

        $this->assertFalse(SubTreeChecker::isSubTree($t1n1, $t3n1));

        $t4n1 = new BinaryTreeNode(10);
        $t4n2 = new BinaryTreeNode(11);

        $t4n1->setLeft($t4n2);

        $this->assertFalse(SubTreeChecker::isSubTree($t1n1, $t4n1));

        $t5n1 = new BinaryTreeNode(3);
        $t5n2 = new BinaryTreeNode(5);

        $t5n1->setLeft($t5n2);

        $this->assertFalse(SubTreeChecker::isSubTree($t1n1, $t5n1));

        $t5n3 = new BinaryTreeNode(6);
        $t5n4 = new BinaryTreeNode(7);

        $t5n1->setRight($t5n3);
        $t5n2->setLeft($t5n4);

        $this->assertFalse(SubTreeChecker::isSubTree($t1n1, $t5n1));
    }
}
