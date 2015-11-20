<?php

class PermutationsWithoutDupsCalculator {

    public static function getPermutations($input) {
        $length = strlen($input);
        if ($length == 1) {
            return [ $input ];
        } elseif ($length == 0) {
            return [];
        }
        $permutations = [];
        for ($i=0; $i<$length; $i++) {
            $char = $input[$i];
            $prefix = substr($input, 0, $i);
            $suffix = substr($input, $i+1);
            $subPermutations = self::getPermutations($prefix . $suffix);
            foreach ($subPermutations as $subPermutation) {
                $permutations[] = $char . $subPermutation;
            }
        }
        return $permutations;
    }
}