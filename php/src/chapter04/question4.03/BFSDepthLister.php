<?php
require_once __DIR__ . '/../../lib/BinaryTreeNode.php';
require_once __DIR__ . '/../../lib/LinkedList.php';

class BFSDepthLister {
    public static function getDepths(BinaryTreeNode $n) {
        $depths = [];
        $nodes = new LinkedList();
        $nodes->add($n);
        while ($nodes !== null) {
            $childNodes = new LinkedList();
            foreach ($nodes as $node) {
                $left = $node->getLeft();
                if ($left !== null) {
                    $childNodes->add($left);
                }
                $right = $node->getRight();
                if ($right !== null) {
                    $childNodes->add($right);
                }
            }
            $depths[] = $nodes;
            $nodes = !$childNodes->isEmpty() ? $childNodes : null;
        }
        return $depths;
    }
}
