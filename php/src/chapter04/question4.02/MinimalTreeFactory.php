<?php
require_once __DIR__ . '/../../lib/BinaryTreeNode.php';

class MinimalTreeFactory {
    public static function build(array $a, $startIndex=0, $endIndex=null) {
        if ($endIndex === null) {
            $endIndex = count($a) - 1;
        }
        $nodeIndex = self::getMidPoint($startIndex, $endIndex);

        $node = new BinaryTreeNode($a[$nodeIndex]);
        if ($nodeIndex - $startIndex > 0) {
            $node->setLeft(self::build($a, $startIndex, $nodeIndex-1));
        }
        if ($endIndex - $nodeIndex > 0) {
            $node->setRight(self::build($a, $nodeIndex+1, $endIndex));
        }
        return $node;
    }

    public static function getMidPoint($p1, $p2) {
        $length = $p2 - $p1;
        if ($length % 2 == 0) {
            return $p1 + $length/2;
        }
        return $p1 + ($length + 1)/2;
    }
}
