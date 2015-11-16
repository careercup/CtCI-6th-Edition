<?php

class CoinCalculator {
    public static function getNumberOfWaysToMakeChange($n) {
        $coins = [ 1, 5, 10, 25 ];
        // initialize memoization array
        $waysOfMakingChange = [ 0 => 1 ]; // there is exactly 1 way of making zero cents
        for ($i=1; $i<=$n; $i++) {
            $waysOfMakingChange[$i] = 0;
        }
        foreach ($coins as $coin) {
            for ($i=$coin; $i<= $n; $i++) {
                $numberOfNewWays = $waysOfMakingChange[$i - $coin];
                $waysOfMakingChange[$i] += $numberOfNewWays;
            }
        }
        return $waysOfMakingChange[$n];
    }
}