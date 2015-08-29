<?php

class MapUniquenessDetector {
    public static function isUnique($str) {
        $charMap = [];
        for ($i=0, $length=strlen($str); $i<$length; $i++) {
            $char = $str[$i];
            if (array_key_exists($char, $charMap)) {
                return false;
            }
            $charMap[$char] = 1;
        }
        return true;
    }
}