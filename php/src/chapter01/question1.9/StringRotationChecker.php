<?php

class StringRotationChecker {
    public static function isRotation($s1, $s2) {
        if (strlen($s1) != strlen($s2)) {
            return false;
        }
        return self::isSubstring($s1 . $s1, $s2);
    }

    public static function isSubstring($haystack, $needle) {
        if (strpos($haystack, $needle) === false) {
            return false;
        }
        return true;
    }
}