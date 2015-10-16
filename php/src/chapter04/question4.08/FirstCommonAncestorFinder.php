<?php
require_once __DIR__ . DIRECTORY_SEPARATOR . 'CommonAncestorResult.php';

class FirstCommonAncestorFinder {

    public static function findFirstCommonAncestor(BinaryTreeNode $node, BinaryTreeNode $p, BinaryTreeNode $q) {
        $result = self::findFirstCommonAncestorResult($node, $p, $q);
        return $result !== null && $result->getCoverCount() === 2 ? $result->getNode() : null;
    }

    protected static function findFirstCommonAncestorResult(BinaryTreeNode $node, BinaryTreeNode $p, BinaryTreeNode $q) {
        $isP = $node === $p;
        $isQ = $node === $q;
        $left = $node->getLeft();
        $right = $node->getRight();
        $leftIsP = false;
        $leftIsQ = false;
        $leftResult = null;
        if ($left !== null) {
            $leftResult = self::findFirstCommonAncestorResult($left, $p, $q);
            $leftReturnNode = $leftResult !== null ? $leftResult->getNode() : null;
            $leftIsP = $leftReturnNode === $p;
            $leftIsQ = $leftReturnNode === $q;
            if ($isP && $leftIsQ || $isQ && $leftIsP) {
                return new CommonAncestorResult($node, 2);
            }
        }
        $rightIsP = false;
        $rightIsQ = false;
        $rightResult = null;
        if ($right !== null) {
            $rightResult = self::findFirstCommonAncestorResult($right, $p, $q);
            $rightReturnNode = $rightResult !== null ? $rightResult->getNode() : null;
            $rightIsP = $rightReturnNode === $p;
            $rightIsQ = $rightReturnNode === $q;
            if ($isP && $rightIsQ || $isQ && $rightIsP) {
                return new CommonAncestorResult($node, 2);
            }
        }
        if ($leftIsP && $rightIsQ || $leftIsQ && $rightIsP) {
            return new CommonAncestorResult($node, 2);
        }
        if ($leftResult !== null) {
            return $leftResult;
        } elseif ($rightResult !== null) {
            return $rightResult;
        } elseif ($isP || $isQ) {
            $coverCount = ($isP ? 1 : 0) + ($isQ ? 1 : 0);
            return new CommonAncestorResult($node, $coverCount);
        }
        return null;
    }
}
