<?php

class Debugger {
    public static function isPowerOfTwo($n) {
        // This expression checks if n is a power of 2 where n > 0
        return ($n & ($n - 1)) == 0;
    }
}