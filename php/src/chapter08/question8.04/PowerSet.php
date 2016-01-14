<?php

class PowerSet {

    public static function getSubsets(array $set) {
        switch (count($set)) {
            case 1:
                return [ [], $set ];
            case 0:
                return [ [] ];
        }
        $subsets = [];
        $value = array_shift($set); // remove the first element
        $recursiveSubsetsWithoutFirstElement = self::getSubsets($set);
        foreach ($recursiveSubsetsWithoutFirstElement as $recursiveSubsetWithoutFirstElement) {
            $subsets[] = $recursiveSubsetWithoutFirstElement;
            $recursiveSubsetWithFirstElement = $recursiveSubsetWithoutFirstElement; // make a copy
            array_unshift($recursiveSubsetWithFirstElement, $value); // re-add the removed element
            $subsets[] = $recursiveSubsetWithFirstElement;
        }
        return $subsets;
    }
}