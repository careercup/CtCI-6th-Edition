<?php
require_once __DIR__ . '/../../../src/chapter04/question4.06/SuccessorNodeFinder.php';

class SuccessorNodeFinderTest extends PHPUnit_Framework_TestCase {

    public function testFindSuccessor() {
        $n1 = new BinaryTreeNodeWithParent(1);
        $n2 = new BinaryTreeNodeWithParent(2);
        $n3 = new BinaryTreeNodeWithParent(3);
        $n4 = new BinaryTreeNodeWithParent(4);
        $n5 = new BinaryTreeNodeWithParent(5);
        $n6 = new BinaryTreeNodeWithParent(6);
        $n7 = new BinaryTreeNodeWithParent(7);
        $n8 = new BinaryTreeNodeWithParent(8);
        $n9 = new BinaryTreeNodeWithParent(9);
        $n10 = new BinaryTreeNodeWithParent(10);
        $n11 = new BinaryTreeNodeWithParent(11);
        $n12 = new BinaryTreeNodeWithParent(12);
        $n13 = new BinaryTreeNodeWithParent(13);
        $n14 = new BinaryTreeNodeWithParent(14);
        $n15 = new BinaryTreeNodeWithParent(15);

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

        $this->assertSame($n2, SuccessorNodeFinder::findSuccessor($n1));
        $this->assertSame($n3, SuccessorNodeFinder::findSuccessor($n2));
        $this->assertSame($n4, SuccessorNodeFinder::findSuccessor($n3));
        $this->assertSame($n5, SuccessorNodeFinder::findSuccessor($n4));
        $this->assertSame($n6, SuccessorNodeFinder::findSuccessor($n5));
        $this->assertSame($n7, SuccessorNodeFinder::findSuccessor($n6));
        $this->assertSame($n8, SuccessorNodeFinder::findSuccessor($n7));
        $this->assertSame($n9, SuccessorNodeFinder::findSuccessor($n8));
        $this->assertSame($n10, SuccessorNodeFinder::findSuccessor($n9));
        $this->assertSame($n11, SuccessorNodeFinder::findSuccessor($n10));
        $this->assertSame($n12, SuccessorNodeFinder::findSuccessor($n11));
        $this->assertSame($n13, SuccessorNodeFinder::findSuccessor($n12));
        $this->assertSame($n14, SuccessorNodeFinder::findSuccessor($n13));
        $this->assertSame($n15, SuccessorNodeFinder::findSuccessor($n14));
        $this->assertNull(SuccessorNodeFinder::findSuccessor($n15));
    }
}
