<?php

class HashMapStringPermutationChecker {
    public static function isPermutation($str1, $str2) {
        $length = strlen($str1);
        if ($length !== strlen($str2)) {
            return false;
        }
        $charCounts1 = [];
        $charCounts2 = [];
        for ($i=0; $i<$length; $i++) {
            $char1 = $str1[$i];
            if (!array_key_exists($char1, $charCounts1)) {
                $charCounts1[$char1]=1;
            } else {
                $charCounts1[$char1]++;
            }
            $char2 = $str2[$i];
            if (!array_key_exists($char2, $charCounts2)) {
                $charCounts2[$char2]=1;
            } else {
                $charCounts2[$char2]++;
            }
        }
        foreach ($charCounts1 as $char => $count) {
            if (!array_key_exists($char, $charCounts2) || $charCounts2[$char] != $count) {
                return false;
            }
        }
        return true;
    }
}