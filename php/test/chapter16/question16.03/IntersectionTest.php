<?php
require_once __DIR__ . '/../../../src/chapter16/question16.03/Intersection.php';

class IntersectionTest extends PHPUnit_Framework_TestCase {

    public function testGetPointOfIntersecton() {
        $point = Intersection::getPointOfIntersecton([ 0, 0 ], [ 4, 4 ], [ 0, 4 ], [ 4, 0 ]);
        $expected = [ 2, 2 ];
        $this->assertEquals($expected, $point);
    }

    public function testGetPointOfIntersectonWithVerticalLine() {
        $point = Intersection::getPointOfIntersecton([ 0, 0 ], [ 4, 4 ], [ 2, 0 ], [ 2, 4 ]);
        $expected = [ 2, 2 ];
        $this->assertEquals($expected, $point);
    }

    public function testGetPointOfIntersectonWithVerticalLine2() {
        $point = Intersection::getPointOfIntersecton([ 2, 0 ], [ 2, 4 ], [ 0, 0 ], [ 4, 4 ]);
        $expected = [ 2, 2 ];
        $this->assertEquals($expected, $point);
    }

    public function testGetPointOfIntersectonWith2OverlappingVerticalLines() {
        $point = Intersection::getPointOfIntersecton([ 2, 0 ], [ 2, 10 ], [ 2, 8 ], [ 2, 16 ]);
        $expected = [ 2, 10 ];
        $this->assertEquals($expected, $point);
    }

    public function testGetPointOfIntersectonWith2NonOverlappingVerticalLines() {
        $point = Intersection::getPointOfIntersecton([ 2, 0 ], [ 2, 4 ], [ 2, 8 ], [ 2, 16 ]);
        $this->assertNull($point);
    }

    public function testGetPointOfIntersectonWithParallelVerticalLines() {
        $point = Intersection::getPointOfIntersecton([ 2, 0 ], [ 2, 4 ], [ 5, 3 ], [ 5, 16 ]);
        $this->assertNull($point);
    }

    public function testGetPointOfIntersectonWithParallelHorizontalLines() {
        $point = Intersection::getPointOfIntersecton([ 0, 4 ], [ 2, 4 ], [ 5, 8 ], [ 10, 8 ]);
        $this->assertNull($point);
    }

    public function testGetPointOfIntersectonWithParallelDiagonalLines() {
        $point = Intersection::getPointOfIntersecton([ 0, 0 ], [ 2, 3 ], [ 1, 1 ], [ 3, 4]);
        $this->assertNull($point);
    }

    public function testGetPointOfIntersectonWith2OverlappingLines() {
        $point = Intersection::getPointOfIntersecton([ 2, 3 ], [ 4, 6 ], [ 4, 6 ], [ 6, 9 ]);
        $expected = [ 4, 6 ];
        $this->assertEquals($expected, $point);
    }

    public function testGetPointOfIntersectonWithNoIntersection() {
        $point = Intersection::getPointOfIntersecton([ 0, 0 ], [ 5, 5 ], [ 1, 4 ], [ 2, 3 ]);
        $this->assertNull($point);
    }

    public function testGetPointOfIntersectonWith2NonOverlappingLineSegmentsOnTheSameLine() {
        $point = Intersection::getPointOfIntersecton([ 0, 0 ], [ 1, 1 ], [ 2, 2 ], [ 3, 3 ]);
        $this->assertNull($point);
    }
}
