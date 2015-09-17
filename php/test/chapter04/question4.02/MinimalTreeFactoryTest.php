<?php
require_once __DIR__ . '/../../../src/chapter04/question4.02/MinimalTreeFactory.php';

class MinimalTreeFactoryTest extends PHPUnit_Framework_TestCase {

    public function testBuild() {
        $a = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 ];
        $one = new BinaryTreeNode(1);
        $two = new BinaryTreeNode(2);
        $three = new BinaryTreeNode(3);
        $four = new BinaryTreeNode(4);
        $five = new BinaryTreeNode(5);
        $six = new BinaryTreeNode(6);
        $seven = new BinaryTreeNode(7);
        $eight = new BinaryTreeNode(8);
        $nine = new BinaryTreeNode(9);
        $ten = new BinaryTreeNode(10);
        $eleven = new BinaryTreeNode(11);
        $twelve = new BinaryTreeNode(12);
        $thirteen = new BinaryTreeNode(13);
        $fourteen = new BinaryTreeNode(14);
        $fifteen = new BinaryTreeNode(15);

        $root = $eight;
        $eight->setLeft($four);
        $eight->setRight($twelve);
        $four->setLeft($two);
        $four->setRight($six);
        $twelve->setLeft($ten);
        $twelve->setRight($fourteen);
        $two->setLeft($one);
        $two->setRight($three);
        $six->setLeft($five);
        $six->setRight($seven);
        $ten->setLeft($nine);
        $ten->setRight($eleven);
        $fourteen->setLeft($thirteen);
        $fourteen->setRight($fifteen);

        $this->assertEquals($root, MinimalTreeFactory::build($a));
    }

    public function testGetMidPoint() {
        $this->assertEquals(7, MinimalTreeFactory::getMidPoint(0, 14));
        $this->assertEquals(4, MinimalTreeFactory::getMidPoint(0, 7));
        $this->assertEquals(13, MinimalTreeFactory::getMidPoint(12, 14));
        $this->assertEquals(14, MinimalTreeFactory::getMidPoint(14, 14));
        $this->assertEquals(7, MinimalTreeFactory::getMidPoint(7, 7));
    }
}
