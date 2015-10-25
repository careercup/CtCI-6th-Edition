<?php

class DecimalConverter {
    const MAX_DIGITS = 32;

    public static function toBinary($n) {
        if ($n > 1 || $n < 0) {
            return 'ERROR';
        }
        $binary = '.';
        $digitCount = 0;
        $f = 0.5;
        while ($n > 0 && ++$digitCount < self::MAX_DIGITS) {
            if ($n >= $f) {
                $binary .= '1';
                $n -= $f;
            } else {
                $binary .= '0';
            }
            $f /= 2;
        }
        if ($digitCount >= self::MAX_DIGITS) {
            return 'ERROR';
        }
        return $binary;
    }
}