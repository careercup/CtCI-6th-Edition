<?php

class ZeroMatrix {
    public static function zero(array &$matrix) {
        $leftColumnZero = false;
        $rowCount = count($matrix);
        for ($i=0; $i<$rowCount; $i++) {
            for ($j=0, $columnCount=count($matrix[$i]); $j<$columnCount; $j++) {
                if ($matrix[$i][$j] === 0) {
                    // use the topmost cell and the leftmost cells in the
                    // matrix to track whether the entire row/column should
                    // be zeroed, respectively.
                    $matrix[$i][0] = 0;
                    if ($j === 0) {
                        // since we are using cell (0,0) in the matrix
                        // to track whether the top row should be zeroed
                        // let's use a single boolean variable to track
                        // whether the left column should be zeroed.
                        $leftColumnZero = true;
                    } else {
                        $matrix[0][$j] = 0;
                    }
                    break;
                }
            }
        }
        // zero out rows based on zero in the first position
        for ($i=1; $i<$rowCount; $i++) {
            if ($matrix[$i][0] === 0) {
                for ($j=1, $columnCount=count($matrix[$i]); $j<$columnCount; $j++) {
                    $matrix[$i][$j] = 0;
                }
            }
        }
        // zero out columns based on zero in the first position
        for ($j=1, $columnCount=count($matrix[0]); $j<$columnCount; $j++) {
            if ($matrix[0][$j] === 0) {
                for ($i=1; $i<$rowCount; $i++) {
                    $matrix[$i][$j] = 0;
                }
            }
        }
        // zero out the top row if needed
        if ($matrix[0][0] === 0) {
            for ($j=1, $columnCount=count($matrix[0]); $j<$columnCount; $j++) {
                $matrix[0][$j] = 0;
            }
        }
        // zero out the left column if needed
        if ($leftColumnZero) {
            for ($i=0; $i<$rowCount; $i++) {
                $matrix[$i][0] = 0;
            }
        }
    }
}
