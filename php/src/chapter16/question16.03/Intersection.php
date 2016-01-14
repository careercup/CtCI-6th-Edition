<?php

class Intersection {

    public static function getPointOfIntersecton(
            array $line1point1, array $line1point2, array $line2point1, array $line2point2) {
        $x1 = $line1point1[0];
        $y1 = $line1point1[1];
        $x2 = $line1point2[0];
        $y2 = $line1point2[1];
        $x3 = $line2point1[0];
        $y3 = $line2point1[1];
        $x4 = $line2point2[0];
        $y4 = $line2point2[1];
        if ($x1 != $x2) {
            // calculate slope and y-intercept for line #1
            $m1 = ($y2 - $y1) / ($x2 - $x1);
            $b1 =  $y1 - $m1 * $x1;
        }
        if ($x3 != $x4) {
            // calculate slope and y-intercept for line #2
            $m2 = ($y4 - $y3) / ($x4 - $x3);
            $b2 =  $y3 - $m2 * $x3;
        }
        if ($x1 != $x2) {
            if ($x3 != $x4) {
                if ($m1 == $m2) { // check if the slopes of the 2 lines are equal
                    if ($b1 == $b2) { // check if the y-intercepts of the 2 lines are equal
                        // these 2 line segments lie on the same line
                        // choose a point on line #1 if possible
                        foreach ([$line1point1, $line1point2] as $testPoint) {
                            if (self::isPointBetween($testPoint, $line2point1, $line2point2)) {
                                return $testPoint;
                            }
                        }
                    }
                    // these 2 line segments are parallel and don't intersect
                    return null;
                } else {
                    // take both lines in y = mx + b format,
                    // set the y expressions equal to each other and solve for x
                    $x = ($b2 - $b1) / ($m1 - $m2);
                    // using x, along with the slope and y-intercept of one of the lines, solve for y
                    $y = $m1 * $x + $b1;
                }
            } else {
                // line #2 has a vertical slope
                $x = $x3;
                $y = $m1 * $x + $b1;
            }
        } elseif ($x3 != $x4) {
            // line #1 has a vertical slope
            $x = $x1;
            $y = $m2 * $x + $b2;
        } else {
            // both lines have vertical slopes
            if ($x1 == $x3) {
                // these 2 vertical line segments lie on the same line
                // choose a point on line #1 if possible
                foreach ([$line1point1, $line1point2] as $testPoint) {
                    if (self::isPointBetween($testPoint, $line2point1, $line2point2)) {
                        return $testPoint;
                    }
                }
            }
            return null;
        }
        $point = [ $x, $y ];
        if (self::isPointBetween($point, $line1point1, $line1point2)
                && self::isPointBetween($point, $line2point1, $line2point2)) {
            return $point;
        }
        return null;
    }

    protected static function isPointBetween(array &$testPoint, array &$point1, array &$point2) {
        $x = $testPoint[0];
        $y = $testPoint[1];
        $minX = min($point1[0], $point2[0]);
        $maxX = max($point1[0], $point2[0]);
        $minY = min($point1[1], $point2[1]);
        $maxY = max($point1[1], $point2[1]);
        return $x >= $minX && $x <= $maxX && $y >= $minY && $y <= $maxY;
    }
}