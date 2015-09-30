<?php
require_once __DIR__ . '/../../lib/BinaryTreeNode.php';

class BinarySearchTreeSequenceCalculator {
    public static function getSequences(BinaryTreeNode $node) {
        $prefix = [ $node->getData() ];
        $left = $node->getLeft();
        $right = $node->getRight();
        if ($left === null && $right === null) {
            return [ $prefix ];
        }
        $leftSequences = $left !== null ? self::getSequences($left) : null;
        $rightSequences = $right !== null ? self::getSequences($right) : null;
        $sequences = [];
        if ($leftSequences === null) {
            foreach ($rightSequences as $rightSequence) {
                $sequences[] = array_merge($prefix, $rightSequence);
            }
            return $sequences;
        }
        if ($rightSequences === null) {
            foreach ($leftSequences as $leftSequence) {
                $sequences[] = array_merge($prefix, $leftSequence);
            }
            return $sequences;
        }
        // combine $leftSequences and $rightSequences in every possible way
        foreach ($leftSequences as $leftSequence) {
            foreach ($rightSequences as $rightSequence) {
                $mergedSequence = array_merge($leftSequence, $rightSequence);
                $orderings = self::getAllOrderings($mergedSequence);
                foreach($orderings as $ordering) {
                    $sequences[] = array_merge($prefix, $ordering);
                }
            }
        }
        return $sequences;
    }

    public static function getAllOrderings(array $list) {
        if (count($list) <= 1) {
            return [ $list ];
        }
        $orderings = [];
        $firstValue = array_shift($list);
        $middlePart = [ $firstValue ];
        $length = count($list);
        $orderingsOfRest = self::getAllOrderings($list);
        foreach ($orderingsOfRest as $ordering) {
            // insert $middlePart in every possible spot within $ordering
            for ($i=0; $i<$length; $i++) {
                $firstPart = array_slice($ordering, 0, $i);
                $lastPart = array_slice($ordering, $i);
                $orderings[] = array_merge($firstPart, $middlePart, $lastPart);
            }
            // last combination is simply adding to the end
            $orderings[] = array_merge($ordering, $middlePart);
        }
        return $orderings;
    }
}