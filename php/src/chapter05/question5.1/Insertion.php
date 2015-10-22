<?php

class Insertion {
    public static function insert($n, $m, $i, $j) {
        $allOnes = ~0;
        $leftSideOfBitMask = ($allOnes << ($j + 1));
        $rightSideOfBitMask = (1 << $i) - 1;
        $bitMask = $leftSideOfBitMask | $rightSideOfBitMask;
        return ($n & $bitMask) | ($m << $i);
    }
}