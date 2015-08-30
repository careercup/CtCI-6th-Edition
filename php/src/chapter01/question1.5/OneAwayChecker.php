<?php

class OneAwayChecker {
    public static function isOneOrZeroAway($str1, $str2) {
        $length1 = strlen($str1);
        $length2 = strlen($str2);
        if (abs($length2 - $length1) > 1) {
            return false;
        }
        if ($length1 == $length2) {
            $diffCount = 0;
            for ($i=0; $i<$length1; $i++) {
                if ($str1[$i] !== $str2[$i]) {
                    if (++$diffCount > 1) {
                        return false;
                    }
                }
            }
        } else {
            if ($length1 > $length2) {
                $longer = $str1;
                $shorter = $str2;
                $longerLength = $length1;
                $shorterLength = $length2;
            } else {
                $longer = $str2;
                $shorter = $str1;
                $longerLength = $length2;
                $shorterLength = $length1;
            }
            $diffCount = 0;
            for ($i=0, $j=0; $i<$longerLength && $j<$shorterLength; $i++, $j++) {
                $char1 = $longer[$i];
                $char2 = $shorter[$j];
                if ($char1 === $char2) {
                    continue;
                }
                if (++$diffCount > 1) {
                    return false;
                }
                $i++; // advance the cursor on the longer string an extra step because we found a diff
            }
        }
        return true;
    }
}