<?php
require_once __DIR__ . '/../../../src/chapter04/question4.11/BinaryTreeNodeWithRandomSelection.php';

class BinaryTreeNodeWithRandomSelectionTest extends PHPUnit_Framework_TestCase {
    private $tree;
    private $n1;
    private $n2;
    private $n3;
    private $n4;
    private $n5;

    public function setUp() {
        $this->n1 = new BinaryTreeNodeWithRandomSelection('a');
        $this->n2 = new BinaryTreeNodeWithRandomSelection('b');
        $this->n3 = new BinaryTreeNodeWithRandomSelection('e');
        $this->n4 = new BinaryTreeNodeWithRandomSelection('c');
        $this->n5 = new BinaryTreeNodeWithRandomSelection('d');

        $this->n2->setLeft($this->n1);
        $this->n2->setRight($this->n3);

        $this->n3->setLeft($this->n4);

        $this->n4->setRight($this->n5);

        $this->tree = $this->n2;

        $this->assertEquals(5, $this->tree->getNodeCount());
        $this->assertEquals(1, $this->n1->getNodeCount());
        $this->assertEquals(3, $this->n3->getNodeCount());
    }

    public function tearDown() {
        $this->n1 = null;
        $this->n2 = null;
        $this->n3 = null;
        $this->n4 = null;
        $this->n5 = null;
        $this->tree = null;
    }

    public function testRandomNode() {
        $resultCounts = [];
        $nodeCount = 5;
        $total = 50000;
        for ($i=0; $i<$total; $i++) {
            $randomNode = $this->tree->getRandomNode();
            $data = $randomNode->getData();
            if (array_key_exists($data, $resultCounts)) {
                $resultCounts[$data]++;
            } else {
                $resultCounts[$data] = 1;
            }
        }
        ksort($resultCounts);
        $expectedCount = $total / $nodeCount;
        $this->assertEquals($nodeCount, count($resultCounts));
        foreach ($resultCounts as $data => $count) {
            $epsilon = abs($count/$expectedCount - 1);
            $this->assertTrue($epsilon < 0.025, 'Expected a value close to ' . $expectedCount . ' but found ' . $count . ' which is off by ' . ($epsilon * 100) . '%');
        }
    }

    public function testFind() {
        $node = $this->tree->find('c');
        $this->assertNotNull($node);
        $this->assertEquals($this->n4->getData(), $node->getData());
    }

    public function testNotFound() {
        $this->assertNull($this->tree->find('q'));
    }

    public function testMin() {
        $this->assertEquals('a', $this->tree->min()->getData());
    }

    public function testMax() {
        $this->assertEquals('e', $this->tree->max()->getData());
    }

    public function testInsert() {
        $this->assertEquals(5, $this->tree->getNodeCount());

        $n6 = $this->tree->insert('h');
        $this->assertNotNull($n6);
        $this->assertEquals('h', $n6->getData());
        $this->assertEquals('e', $n6->getParent()->getData());
        $this->assertSame($n6, $this->n3->getRight());
        $this->assertEquals(6, $this->tree->getNodeCount());

        $n7 = $this->tree->insert('g');
        $this->assertNotNull($n7);
        $this->assertEquals('g', $n7->getData());
        $this->assertEquals('h', $n7->getParent()->getData());
        $this->assertSame($n7, $n6->getLeft());
        $this->assertEquals(7, $this->tree->getNodeCount());

        $n8 = $this->tree->insert('f');
        $this->assertNotNull($n8);
        $this->assertEquals('f', $n8->getData());
        $this->assertEquals('g', $n8->getParent()->getData());
        $this->assertSame($n8, $n7->getLeft());
        $this->assertEquals(8, $this->tree->getNodeCount());

        $this->assertNull($this->tree->insert('f'), 'Cannot insert the same value twice!');
    }

    public function testDeleteNonExistentNode() {
        $this->assertFalse($this->tree->delete('q'));
    }

    public function testDeleteLeftLeafNode() {
        $this->assertEquals(5, $this->tree->getNodeCount());
        $this->assertEquals('a', $this->n2->getLeft()->getData());
        $this->assertTrue($this->tree->delete('a'));
        $this->assertNull($this->n2->getLeft());
        $this->assertNull($this->tree->find('a'));
        $this->assertEquals(4, $this->tree->getNodeCount());
    }

    public function testDeleteRightLeafNode() {
        $this->assertEquals(5, $this->tree->getNodeCount());
        $this->assertEquals('d', $this->n4->getRight()->getData());
        $this->assertTrue($this->tree->delete('d'));
        $this->assertNull($this->n4->getRight());
        $this->assertNull($this->tree->find('d'));
        $this->assertEquals(4, $this->tree->getNodeCount());
    }

    public function testDeleteNodeWithRightChildAndReparentLeft() {
        $this->assertEquals(5, $this->tree->getNodeCount());
        $this->assertEquals('c', $this->n3->getLeft()->getData());
        $this->assertTrue($this->tree->delete('c'));
        $this->assertEquals('d', $this->n3->getLeft()->getData());
        $this->assertNull($this->tree->find('c'));
        $this->assertEquals(4, $this->tree->getNodeCount());
    }

    public function testDeleteNodeWithRightChildAndReparentRight() {
        $this->assertEquals(5, $this->tree->getNodeCount());
        $n6 = new BinaryTreeNodeWithRandomSelection('h');
        $this->n3->setRight($n6);
        $this->assertEquals('h', $this->tree->find('h')->getData());
        $this->assertEquals('h', $this->n3->getRight()->getData());
        $this->assertEquals(6, $this->tree->getNodeCount());

        $n7 = new BinaryTreeNodeWithRandomSelection('i');
        $n6->setRight($n7);
        $this->assertEquals('i', $this->tree->find('i')->getData());
        $this->assertEquals(7, $this->tree->getNodeCount());

        $this->assertTrue($this->tree->delete('h'));
        $this->assertNull($this->tree->find('h'));
        $this->assertEquals('i', $this->tree->find('i')->getData());
        $this->assertEquals('i', $this->n3->getRight()->getData());
        $this->assertEquals(6, $this->tree->getNodeCount());
    }

    public function testDeleteNodeWithLeftChildAndReparentLeft() {
        $this->assertEquals(5, $this->tree->getNodeCount());
        $n6 = new BinaryTreeNodeWithRandomSelection('h');
        $this->n3->setRight($n6);
        $this->assertEquals('h', $this->tree->find('h')->getData());
        $this->assertEquals('h', $this->n3->getRight()->getData());
        $this->assertEquals(6, $this->tree->getNodeCount());

        $n7 = new BinaryTreeNodeWithRandomSelection('g');
        $n6->setLeft($n7);
        $this->assertEquals('g', $this->tree->find('g')->getData());
        $this->assertEquals(7, $this->tree->getNodeCount());

        $n8 = new BinaryTreeNodeWithRandomSelection('f');
        $n7->setLeft($n8);
        $this->assertEquals('f', $this->tree->find('f')->getData());
        $this->assertEquals(8, $this->tree->getNodeCount());

        $this->assertTrue($this->tree->delete('g'));
        $this->assertNull($this->tree->find('g'));
        $this->assertEquals('f', $this->tree->find('f')->getData());
        $this->assertEquals('f', $n6->getLeft()->getData());
        $this->assertEquals(7, $this->tree->getNodeCount());
    }

    public function testDeleteNodeWithLeftChildAndReparentRight() {
        $this->assertEquals(5, $this->tree->getNodeCount());
        $n6 = new BinaryTreeNodeWithRandomSelection('h');
        $this->n3->setRight($n6);
        $this->assertEquals('h', $this->tree->find('h')->getData());
        $this->assertEquals('h', $this->n3->getRight()->getData());
        $this->assertEquals(6, $this->tree->getNodeCount());

        $n7 = new BinaryTreeNodeWithRandomSelection('g');
        $n6->setLeft($n7);
        $this->assertEquals('g', $this->tree->find('g')->getData());
        $this->assertEquals(7, $this->tree->getNodeCount());

        $this->assertTrue($this->tree->delete('h'));
        $this->assertNull($this->tree->find('h'));
        $this->assertEquals('g', $this->tree->find('g')->getData());
        $this->assertEquals('g', $this->n3->getRight()->getData());
        $this->assertEquals(6, $this->tree->getNodeCount());
    }

    public function testDeleteRightNodeWithTwoChildNodesThatAreLeafNodes() {
        $this->assertEquals(5, $this->tree->getNodeCount());
        $n6 = new BinaryTreeNodeWithRandomSelection('h');
        $this->n3->setRight($n6);
        $this->assertEquals('h', $this->tree->find('h')->getData());
        $this->assertEquals('h', $this->n3->getRight()->getData());
        $this->assertEquals(6, $this->tree->getNodeCount());

        $n7 = new BinaryTreeNodeWithRandomSelection('g');
        $n6->setLeft($n7);
        $this->assertEquals('g', $this->tree->find('g')->getData());
        $this->assertEquals(7, $this->tree->getNodeCount());

        $n8 = new BinaryTreeNodeWithRandomSelection('j');
        $n6->setRight($n8);
        $this->assertEquals('j', $this->tree->find('j')->getData());
        $this->assertEquals(8, $this->tree->getNodeCount());

        $this->assertTrue($this->tree->delete('h'));
        $this->assertNull($this->tree->find('h'));
        $this->assertEquals('g', $this->tree->find('g')->getData());
        $this->assertEquals('j', $this->tree->find('j')->getData());
        $this->assertEquals('j', $this->n3->getRight()->getData());
        $this->assertEquals('g', $n8->getLeft()->getData());
        $this->assertEquals(7, $this->tree->getNodeCount());
    }

    public function testDeleteNodeWithTwoChildNodesThatAreNonLeafNodes() {
        $this->assertEquals(5, $this->tree->getNodeCount());
        $n6 = new BinaryTreeNodeWithRandomSelection('h');
        $this->n3->setRight($n6);
        $this->assertEquals('h', $this->tree->find('h')->getData());
        $this->assertEquals('h', $this->n3->getRight()->getData());
        $this->assertEquals(6, $this->tree->getNodeCount());

        $n7 = new BinaryTreeNodeWithRandomSelection('g');
        $n6->setLeft($n7);
        $this->assertEquals('g', $this->tree->find('g')->getData());
        $this->assertEquals(7, $this->tree->getNodeCount());

        $n8 = new BinaryTreeNodeWithRandomSelection('j');
        $n6->setRight($n8);
        $this->assertEquals('j', $this->tree->find('j')->getData());
        $this->assertEquals(8, $this->tree->getNodeCount());

        $n9 = new BinaryTreeNodeWithRandomSelection('f');
        $n7->setLeft($n9);
        $this->assertEquals('f', $this->tree->find('f')->getData());
        $this->assertEquals(9, $this->tree->getNodeCount());

        $n10 = new BinaryTreeNodeWithRandomSelection('i');
        $n8->setLeft($n10);
        $this->assertEquals('i', $this->tree->find('i')->getData());
        $this->assertEquals(10, $this->tree->getNodeCount());

        $this->assertTrue($this->tree->delete('h'));
        $this->assertNull($this->tree->find('h'));
        $this->assertEquals('f', $this->tree->find('f')->getData());
        $this->assertEquals('g', $this->tree->find('g')->getData());
        $this->assertEquals('i', $this->tree->find('i')->getData());
        $this->assertEquals('j', $this->tree->find('j')->getData());

        $this->assertEquals('i', $this->n3->getRight()->getData());
        $this->assertEquals('g', $n10->getLeft()->getData());
        $this->assertEquals('j', $n10->getRight()->getData());
        $this->assertNull($n8->getRight());
        $this->assertNull($n8->getLeft());
        $this->assertEquals(9, $this->tree->getNodeCount());
    }
}
