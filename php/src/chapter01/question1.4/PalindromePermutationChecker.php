<?php

class PalindromePermutationChecker {
    public static function isPalindromePermutation($str) {
        $charCounts = [];
        for ($i=0, $length=strlen($str); $i<$length; $i++) {
            $char = $str[$i];
            // ignore spaces
            if ($char === ' ') {
                continue;
            }
            $char = strtolower($char);
            if (array_key_exists($char, $charCounts)) {
                $charCounts[$char]++;
            } else {
                $charCounts[$char] = 1;
            }
        }
        $oddCount = 0;
        foreach ($charCounts as $char => $count) {
            if ($count % 2 != 0 && ++$oddCount > 1) {
                return false;
            }
        }
        return true;
    }
}