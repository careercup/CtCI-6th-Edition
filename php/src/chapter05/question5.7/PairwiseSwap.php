<?php

class PairwiseSwap {
    const EVEN_BIT_MASK = 0b10101010101010101010101010101010;
    const ODD_BIT_MASK  = 0b01010101010101010101010101010101;

    public static function swap($n) {
        return (($n & self::EVEN_BIT_MASK) >> 1) | (($n & self::ODD_BIT_MASK) << 1);
    }
}