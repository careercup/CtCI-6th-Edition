<?php

class SortingStringPermutationChecker {
    public static function isPermutation($str1, $str2) {
        if (strlen($str1) !== strlen($str2)) {
            return false;
        }
        $charArray1 = str_split($str1);
        $charArray2 = str_split($str2);
        sort($charArray1);
        sort($charArray2);
        $sortedStr1 = implode('', $charArray1);
        $sortedStr2 = implode('', $charArray2);
        return $sortedStr1 === $sortedStr2 ? true : false;
    }
}