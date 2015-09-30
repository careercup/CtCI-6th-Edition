<?php

class StackSorter {
    public static function sort(array &$stack) {
        if (empty($stack)) {
            return;
        }
        $unprocessedCount = null;
        $tempStack = [];
        do {
            $max = null;
            $i = 0;
            while ($unprocessedCount === null && !empty($stack) || $i < $unprocessedCount) {
                $value = array_pop($stack);
                if ($max === null) {
                    $max = $value;
                } elseif ($value > $max) {
                    array_push($tempStack, $max);
                    $max = $value;
                } else {
                    array_push($tempStack, $value);
                }
                $i++;
            }
            array_push($stack, $max);
            while (!empty($tempStack)) {
                array_push($stack, array_pop($tempStack));
            }
            $unprocessedCount = $i - 1;
        } while ($unprocessedCount > 0);
    }
}
