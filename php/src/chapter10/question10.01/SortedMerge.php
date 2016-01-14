<?php

class SortedMerge {

    public static function merge(array &$a, array &$b) {
        $aSize = count($a);
        $bSize = count($b);
        if ($bSize > $aSize) {
            throw new InvalidArgumentException('The first array must be larger than the second array.');
        }
        $bCursor = $bSize - 1;
        $aCursor = $aSize - $bSize - 1;
        $combinedCursor = $aSize - 1;
        while ($combinedCursor >= 0) {
            if ($aCursor < 0) {
                $value = $b[$bCursor--];
            } elseif ($bCursor < 0) {
                $value = $a[$aCursor--];
            } elseif ($a[$aCursor] >= $b[$bCursor]) {
                $value = $a[$aCursor--];
            } else {
                $value = $b[$bCursor--];
            }
            $a[$combinedCursor--] = $value;
        }
    }
}