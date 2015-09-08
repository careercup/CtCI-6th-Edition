<?php

class MatrixRotator {
    public static function rotate(array &$matrix) {
        $length = count($matrix);
        // process 1 layer of the matrix at a time
        // starting from the outside and moving inwards
        for ($layer=0, $layerCount=$length/2; $layer<$layerCount; $layer++) {
            $start = $layer;
            $end = $length - $start - 1;
            for ($j=$start; $j<$end; $j++) {
                // perform a 4-way swap of values in the current layer
                $temp = $matrix[$j][$layer];

                $matrix[$j][$layer] = $matrix[$length - $layer - 1][$j];

                $matrix[$length - $layer - 1][$j] = $matrix[$length - $j - 1][$length - $layer - 1];

                $matrix[$length - $j - 1][$length - $layer - 1] = $matrix[$layer][$length - $j - 1];

                $matrix[$layer][$length - $j - 1] = $temp;
            }
        }
    }
}
