<?php

class MonochromeScreen {
    public static function drawLine(array &$screen, $width, $x1, $x2, $y) {
        if ($x2 < $x1) {
            $tmp = $x1;
            $x1 = $x2;
            $x2 = $tmp;
        }
        $fullByte = 0b11111111;
        $bytesPerRow = $width / 8;
        $startOfRowIndex = $bytesPerRow * $y;
        $startIndex = $startOfRowIndex + (int) ($x1 / 8);
        $endIndex = $startOfRowIndex + (int) ($x2 / 8);

        $startIndexMask = ($fullByte >> ($x1 % 8));
        $endIndexMask = (~($fullByte >> ($x2 % 8) + 1) & $fullByte);

        if ($startIndex === $endIndex) {
            $tmpMask = $startIndexMask;
            $startIndexMask &= $endIndexMask;
            $endIndexMask &= $tmpMask;
        }

        $screen[$startIndex] = ($screen[$startIndex] | $startIndexMask);
        $screen[$endIndex] = ($screen[$endIndex] | $endIndexMask);
        for ($i=$startIndex+1; $i<$endIndex; $i++) {
            $screen[$i] = $fullByte;
        }
    }
}