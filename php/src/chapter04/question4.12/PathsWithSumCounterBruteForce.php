<?php
require_once __DIR__ . '/../../lib/BinaryTreeNode.php';

class PathsWithSumCounterBruteForce {
    public static function countPathsWithSum(BinaryTreeNode $node, $targetSum, array $breadCrumb=[]) {
        $newBreadCrumb = array_merge($breadCrumb, [ $node->getData() ]);
        $resultCount = self::getPathSumCount($newBreadCrumb, $targetSum);
        $left = $node->getLeft();
        if ($left !== null) {
            $resultCount += self::countPathsWithSum($left, $targetSum, $newBreadCrumb);
        }
        $right = $node->getRight();
        if ($right !== null) {
            $resultCount += self::countPathsWithSum($right, $targetSum, $newBreadCrumb);
        }
        return $resultCount;
    }

    public static function getPathSumCount(array $values, $targetSum) {
        $sumCount = 0;
        $runningSum = 0;
        for ($i=count($values)-1; $i>=0; $i--) {
            $runningSum += $values[$i];
            if ($runningSum === $targetSum) {
                $sumCount++;
            }
        }
        return $sumCount;
    }
}