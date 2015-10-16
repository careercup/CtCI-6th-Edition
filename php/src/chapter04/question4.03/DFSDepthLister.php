<?php
require_once __DIR__ . '/../../lib/BinaryTreeNode.php';
require_once __DIR__ . '/../../lib/LinkedList.php';

class DFSDepthLister {
    public static function getDepths(BinaryTreeNode $n) {
        $depths = [];
        self::populateDepths($depths, $n, 0);
        return $depths;
    }

    private static function populateDepths(array &$depths, BinaryTreeNode $n, $depth) {
        $nodeList = $depth < count($depths) ? $depths[$depth] : null;
        if ($nodeList === null) {
            $nodeList = new LinkedList();
            $depths[$depth] = $nodeList;
        }
        $nodeList->add($n);
        $left = $n->getLeft();
        if ($left !== null) {
            self::populateDepths($depths, $left, $depth+1);
        }
        $right = $n->getRight();
        if ($right !== null) {
            self::populateDepths($depths, $right, $depth+1);
        }
    }
}
