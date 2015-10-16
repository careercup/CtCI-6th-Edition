<?php
require_once __DIR__ . '/../../lib/BinaryTreeNode.php';

class SubTreeChecker {
    public static function isSubTree(BinaryTreeNode $haystackTree, BinaryTreeNode $needleTree) {
        $queue = [ $haystackTree ];
        while (!empty($queue)) {
            $node = array_shift($queue);
            if (self::areTreesEqual($node, $needleTree)) {
                return true;
            }
            $left = $node->getLeft();
            if ($left !== null) {
                array_push($queue, $left);
            }
            $right = $node->getRight();
            if ($right !== null) {
                array_push($queue, $right);
            }
        }
        return false;
    }

    public static function areTreesEqual(BinaryTreeNode $tree1, BinaryTreeNode $tree2) {
        if ($tree1->getData() !== $tree2->getData()) {
            return false;
        }
        $queue1 = [ $tree1 ];
        $queue2 = [ $tree2 ];
        while (!empty($queue1)) {
            $node1 = array_shift($queue1);
            $node2 = array_shift($queue2);

            $pairs = [
                [ $node1->getLeft(), $node2->getLeft() ],
                [ $node1->getRight(), $node2->getRight() ]
            ];

            foreach ($pairs as $pair) {
                if ($pair[0] === null) {
                    if ($pair[1] !== null) {
                        return false;
                    }
                } elseif ($pair[1] === null) {
                      return false;
                } elseif ($pair[0]->getData() !== $pair[1]->getData()) {
                    return false;
                } else {
                    array_push($queue1, $pair[0]);
                    array_push($queue2, $pair[1]);
                }
            }
        }
        return true;
    }
}