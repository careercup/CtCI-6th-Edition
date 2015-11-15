<?php
require_once __DIR__ . '/../../../src/chapter07/question7.10/RandomPointGenerator.php';

class RandomPointGeneratorTest extends PHPUnit_Framework_TestCase {

    public function testRandomPointGenerator() {
        $count = 8;
        $safeRow = 2;
        $safeColumn = 4;
        $length = 6;
        $width = 10;
        $points = RandomPointGenerator::generate($length, $width, $safeRow, $safeColumn, $count);
        $this->assertEquals($count, count($points));
        $pointStrings = [];
        foreach ($points as $point) {
            $this->assertFalse($point->getRow() == $safeRow && $point->getColumn() == $safeColumn);
            $pointString = (string) $point;
            $this->assertFalse(in_array($pointString, $pointStrings));
            $pointStrings[] = $pointString;
        }
    }
}
