<?php

class PairSumFinder {

    public static function findPairsWithSum($sum, array &$arr) {
        $pairs = [];
        $map = [];
        foreach($arr as $index => $value) {
            $difference = $sum - $value;
            if (isset($map[$difference]) && !isset($map[$value])) {
                $pairs[] = [ $difference, $value ];
            }
            $map[$value] = $index;
        }
        return $pairs;
    }
}