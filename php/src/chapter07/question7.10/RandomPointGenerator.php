<?php
require_once __DIR__ . DIRECTORY_SEPARATOR . 'Point.php';

class RandomPointGenerator {
    public static function generate($length, $width, $safeRow, $safeColumn, $count) {
        $max = $length * $width - 1;
        $checklist = [];
        $points = [];
        while (count($points) < $count) {
            $index = mt_rand(0, $max);
            if (isset($checklist[$index])) {
                continue;
            }
            $column = $index % $width;
            $row = ($index - $column) / $width;
            if ($row == $safeRow && $column == $safeColumn) {
                continue;
            }
            $checklist[$index] = true;
            $points[] = new Point($row, $column);
        }
        return $points;
    }
}