<?php
require_once __DIR__ . '/../../lib/BinaryTreeNodeWithParent.php';

class SuccessorNodeFinder {
    public static function findSuccessor(BinaryTreeNodeWithParent $node) {
        $right = $node->getRight();
        if ($right !== null) {
            return self::diveDownAndLeft($right);
        }
        $rightMostParent = self::climbUpAndRight($node);
        // The parent of rightMostParent must be a left parent or null
        // because we climbed as far right as possible
        return $rightMostParent->getParent();
    }

    protected static function diveDownAndLeft(BinaryTreeNodeWithParent $node) {
        $last = $node;
        while (($node = $last->getLeft()) !== null) {
            $last = $node;
        }
        return $last;
    }

    protected static function climbUpAndRight(BinaryTreeNodeWithParent $node) {
        $parent = $node;
        while (($parent = $node->getParent()) !== null) {
            if ($node === $parent->getLeft()) {
                return $node;
            }
            $node = $parent;
        }
        return $node;
    }
}
