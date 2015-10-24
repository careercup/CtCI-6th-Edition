<?php

class Conversion {
    public static function getBitFlipCount($n1, $n2) {
        $bitsToFlip = $n1 ^ $n2;
        $count = 0;
        while ($bitsToFlip > 0) {
            if (($bitsToFlip & 1) === 1) {
                $count++;
            }
            $bitsToFlip = $bitsToFlip >> 1;
        }
        return $count;
    }
}