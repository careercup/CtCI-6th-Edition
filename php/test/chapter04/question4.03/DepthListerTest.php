<?php
require_once __DIR__ . '/../../../src/chapter04/question4.03/BFSDepthLister.php';
require_once __DIR__ . '/../../../src/chapter04/question4.03/DFSDepthLister.php';

class DepthListerTest extends PHPUnit_Framework_TestCase {

    public function testGetDepths() {
        $firstLevel1 = new BinaryTreeNode("first level 1");
        $secondLevel1 = new BinaryTreeNode("second level 1");
        $secondLevel2 = new BinaryTreeNode("second level 2");
        $thirdLevel1 = new BinaryTreeNode("third level 1");
        $thirdLevel2 = new BinaryTreeNode("third level 2");
        $thirdLevel3 = new BinaryTreeNode("third level 3");
        $fourthLevel1 = new BinaryTreeNode("fourth level 1");

        $firstLevel1->setLeft($secondLevel1);
        $firstLevel1->setRight($secondLevel2);

        $secondLevel1->setRight($thirdLevel1);
        $secondLevel2->setLeft($thirdLevel2);
        $secondLevel2->setRight($thirdLevel3);

        $thirdLevel2->setLeft($fourthLevel1);

        $firstLevel = new LinkedList();
        $firstLevel->add($firstLevel1);

        $secondLevel = new LinkedList();
        $secondLevel->add($secondLevel1);
        $secondLevel->add($secondLevel2);

        $thirdLevel = new LinkedList();
        $thirdLevel->add($thirdLevel1);
        $thirdLevel->add($thirdLevel2);
        $thirdLevel->add($thirdLevel3);

        $fourthLevel = new LinkedList();
        $fourthLevel->add($fourthLevel1);

        $expected = [$firstLevel, $secondLevel, $thirdLevel, $fourthLevel];

        $this->assertEquals($expected, DFSDepthLister::getDepths($firstLevel1));
        $this->assertEquals($expected, BFSDepthLister::getDepths($firstLevel1));
    }
}
