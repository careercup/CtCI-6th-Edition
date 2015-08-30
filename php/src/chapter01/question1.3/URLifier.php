<?php

class URLifier {
    public static function urlify(&$str) {
        // start at the end and swallow all spaces
        $length = strlen($str);
        for ($i = $length - 1; $i >= 0; $i--) {
            if ($str[$i] !== ' ') {
                break;
            }
        }
        // fill in string in reverse order
        // begining with the first non-space
        // character from the right
        $j = $length - 1;
        while ($i >= 0) {
            if ($str[$i] === ' ') {
                $str[$j--] = '0';
                $str[$j--] = '2';
                $str[$j--] = '%';
            } else {
                $str[$j--] = $str[$i];
            }
            $i--;
        }
    }
}