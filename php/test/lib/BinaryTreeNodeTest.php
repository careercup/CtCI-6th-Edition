<?php
require_once __DIR__ . '/../../src/lib/BinaryTreeNode.php';

class BinaryTreeNodeTest extends PHPUnit_Framework_TestCase {

    public function testBinaryTreeNode() {
        $node1 = new BinaryTreeNode('Dizzy');
        $this->assertEquals('Dizzy', $node1->getData());
        $this->assertEquals('Dizzy', (string) $node1);

        $node1->setData('Miles');
        $this->assertEquals('Miles', $node1->getData());
        $this->assertEquals('Miles', (string) $node1);

        $this->assertNull($node1->getLeft());
        $this->assertNull($node1->getRight());

        $node2 = new BinaryTreeNode('Cannonball');
        $node3 = new BinaryTreeNode('Coltrane');

        $node1->setLeft($node2);
        $node1->setRight($node3);

        $this->assertSame($node2, $node1->getLeft());
        $this->assertSame($node3, $node1->getRight());
    }
}