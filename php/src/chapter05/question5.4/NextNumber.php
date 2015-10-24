<?php

class NextNumber {
    public static function getPreviousAndNextNumbersWithSameNumberOfOneBits($n) {
        $nextLowestNumber = null;
        $nextHighestNumber = null;
        $i = 0;
        $mask = 0b11;
        while ((1 << $i) <= $n && ($nextLowestNumber === null || $nextHighestNumber === null)) {
            $twoDigits = (($n & $mask) >> $i);
            if ($twoDigits === 0b10) {
                if ($nextLowestNumber === null) {
                    $clearMask = self::getTwoDigitClearMask($i);
                    $swappedTwoDigits = (1 << $i);
                    $nextLowestNumber = (($n & $clearMask) | $swappedTwoDigits);
                }
            } elseif ($twoDigits === 0b01) {
                if ($nextHighestNumber === null) {
                    $clearMask = self::getTwoDigitClearMask($i);
                    $swappedTwoDigits = (1 << ($i + 1));
                    $nextHighestNumber = (($n & $clearMask) | $swappedTwoDigits);
                }
            }
            $mask = ($mask << 1);
            $i++;
        }
        return [ $nextLowestNumber, $nextHighestNumber ];
    }

    private static function getTwoDigitClearMask($i) {
        $allOnes = ~0;
        $leftSideOfMask = ($allOnes << ($i + 2));
        $rightSideOfMask = (1 << $i) - 1;
        return ($leftSideOfMask | $rightSideOfMask);
    }
}