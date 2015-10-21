<?php

class BitFlipper {
    const BIT_COUNT = 32;

    public static function flipBitToWin($number) {
        $consecutiveOnes = 0;
        $consecutiveZeros = 0;
        $previousStreakOfOnes = 0;
        $previousStreakOfZeros = 0;
        $longestStreak = 0;
        for ($i=0, $v=1; $i<self::BIT_COUNT; $i++, $v = $v << 1) {
            if (($number & $v) === $v) {
                if ($consecutiveZeros > 0) {
                    $previousStreakOfZeros = $consecutiveZeros;
                    $consecutiveZeros = 0;
                }
                $consecutiveOnes++;
            } else {
                if ($consecutiveOnes > 0) {
                    $streak = $consecutiveOnes + 1;
                    if ($previousStreakOfZeros === 1) {
                        $streak += $previousStreakOfOnes;
                    }
                    if ($streak > $longestStreak) {
                        $longestStreak = $streak;
                    }
                    $previousStreakOfOnes = $consecutiveOnes;
                    $consecutiveOnes = 0;
                }
                $consecutiveZeros++;
            }
        }
        $streak = $consecutiveOnes + 1;
        if ($previousStreakOfZeros === 1) {
            $streak += $previousStreakOfOnes;
        }
        if ($streak > $longestStreak) {
            $longestStreak = $streak;
        }
        if ($longestStreak > self::BIT_COUNT) {
            $longestStreak = self::BIT_COUNT;
        }
        return $longestStreak;
    }
}