<?php

class Parens {

    public static function getParenCombinations($numToOpen, $numToClose=0, $prefix='') {
        if ($numToOpen == 0 && $numToClose == 0) {
            return [ $prefix ];
        }
        $combinations = [];
        if ($numToOpen > 0) {
            $openCombinations = self::getParenCombinations($numToOpen-1, $numToClose+1, $prefix . '(');
            $combinations = array_merge($combinations, $openCombinations);
        }
        if ($numToClose > 0) {
            $closeCombinations = self::getParenCombinations($numToOpen, $numToClose-1, $prefix . ')');
            $combinations = array_merge($combinations, $closeCombinations);
        }
        return $combinations;
    }
}