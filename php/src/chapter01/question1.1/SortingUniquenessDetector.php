<?php

class SortingUniquenessDetector {
    public static function isUnique($str) {
        $charArray = str_split($str);
        sort($charArray);
        $lastChar = null;
        foreach ($charArray as $char) {
            if ($char === $lastChar) {
                return false;
            }
            $lastChar = $char;
        }
        return true;
    }
}