<?php

class TripleStep {
    public static function getNumberOfWaysToClimbSteps($n) {
        $stepSizes = [ 1, 2, 3 ];
        // initialize memoization array
        $waysToClimbSteps = [ 0 => 1 ]; // There is exactly 1 way to climb zero steps. i.e. not to do it
        for ($i=1; $i<=$n; $i++) {
            $waysToClimbSteps[$i] = 0;
        }
        for ($i=0; $i<=$n; $i++) {
            $waysToClimbToThisPoint = $waysToClimbSteps[$i];
            foreach ($stepSizes as $stepSize) {
                if ($i + $stepSize > $n) {
                    break;
                }
                $waysToClimbSteps[$i + $stepSize] += $waysToClimbToThisPoint;
            }
        }
        return $waysToClimbSteps[$n];
    }
}