<?php
require_once __DIR__ . '/../../lib/BinaryTreeNode.php';

class BalancedTreeChecker {
    public static function isBalanced(BinaryTreeNode $node) {
        return self::getMaxDepthOrNegativeOneIfUnbalanced($node) != -1;
    }

    public static function getMaxDepthOrNegativeOneIfUnbalanced(BinaryTreeNode $node=null) {
        if ($node === null) {
            return 0;
        }
        $leftDepth = self::getMaxDepthOrNegativeOneIfUnbalanced($node->getLeft());
        if ($leftDepth == -1) {
            return -1;
        }
        $rightDepth = self::getMaxDepthOrNegativeOneIfUnbalanced($node->getRight());
        if ($rightDepth == -1) {
            return -1;
        }
        if (abs($leftDepth - $rightDepth) > 1) {
            return -1;
        }
        return max($leftDepth, $rightDepth) + 1;
    }
}
