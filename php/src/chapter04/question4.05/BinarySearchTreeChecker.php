<?php
require_once __DIR__ . '/../../lib/BinaryTreeNode.php';

class BinarySearchTreeChecker {
    public static function isBinarySearchTree(BinaryTreeNode $node, $min=null, $max=null) {
        $left = $node->getLeft();
        $right = $node->getRight();
        $nodeValue = $node->getData();
        if ($left !== null) {
            $leftValue = $left->getData();
            if ($nodeValue < $leftValue) {
                return false;
            }
            if ($min !== null && $min > $leftValue) {
                return false;
            }
            if (!self::isBinarySearchTree($left, $min, $nodeValue)) {
                return false;
            }
        }
        if ($right !== null) {
            $rightValue = $right->getData();
            if ($nodeValue > $rightValue) {
                return false;
            }
            if ($max !== null && $max < $rightValue) {
                return false;
            }
            if (!self::isBinarySearchTree($right, $nodeValue, $max)) {
                return false;
            }
        }
        return true;
    }
}
