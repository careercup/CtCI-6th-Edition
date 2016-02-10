<?php
require_once __DIR__ . '/../../lib/BinaryTreeNode.php';

class PathsWithSumCounter {
    public static function countPathsWithSum(BinaryTreeNode $node=null, $targetSum, $runningSum=0, array &$pathCountMap=[]) {
        if ($node === null) {
            return 0;
        }
        $runningSum += $node->getData();
        $sum = $runningSum - $targetSum;

        $totalPaths = array_key_exists($sum, $pathCountMap) ? $pathCountMap[$sum] : 0;

        if ($runningSum === $targetSum) {
            $totalPaths++;
        }
        $pathCountMap[$runningSum] = (array_key_exists($runningSum, $pathCountMap) ? $pathCountMap[$runningSum] : 0) + 1;

        $totalPaths += self::countPathsWithSum($node->getLeft(), $targetSum, $runningSum, $pathCountMap);
        $totalPaths += self::countPathsWithSum($node->getRight(), $targetSum, $runningSum, $pathCountMap);
        $pathCountMap[$runningSum] -= 1;
        return $totalPaths;
    }
}