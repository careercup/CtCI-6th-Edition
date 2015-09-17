<?php
require_once __DIR__ . '/../../lib/BinaryTreeNode.php';

class BalancedTreeChecker {
    public static function isBalanced(BinaryTreeNode $node) {
        return self::getMaxDepthOrNegativeOneIfUnbalanced($node) != -1;
    }

    public static function getMaxDepthOrNegativeOneIfUnbalanced(BinaryTreeNode $node) {
        $left = $node->getLeft();
        $right = $node->getRight();
        $leftDepth = $left !== null ? self::getMaxDepthOrNegativeOneIfUnbalanced($left) : 0;
        if ($leftDepth == -1) {
            return -1;
        }
        $rightDepth = $right !== null ? self::getMaxDepthOrNegativeOneIfUnbalanced($right) : 0;
        if ($rightDepth == -1) {
            return -1;
        }
        if (abs($leftDepth - $rightDepth) > 1) {
            return -1;
        }
        return max($leftDepth, $rightDepth) + 1;
    }
}
