<?php
require_once __DIR__ . '/../../../src/chapter01/question1.8/ZeroMatrix.php';

class ZeroMatrixTest extends PHPUnit_Framework_TestCase {

    public function testZeroMatrixWithZeroedTopRow() {
        $matrix = [
            [ 1,  2,  3,  4,  0,  6],
            [ 7,  8,  9, 10, 11, 12],
            [13, 14, 15, 16, 17, 18],
            [19, 20,  0, 22, 23, 24],
            [25, 26, 27, 28, 29, 30],
            [31, 32, 33, 34, 35, 36]
        ];
        $expected = [
            [ 0,  0,  0,  0,  0,  0],
            [ 7,  8,  0, 10,  0, 12],
            [13, 14,  0, 16,  0, 18],
            [ 0,  0,  0,  0,  0,  0],
            [25, 26,  0, 28,  0, 30],
            [31, 32,  0, 34,  0, 36]
        ];
        ZeroMatrix::zero($matrix);
        $this->assertEquals($expected, $matrix);
    }

    public function testZeroMatrixWithZeroedLeftColumn() {
        $matrix = [
            [ 1,  2,  3,  4,  5,  6],
            [ 7,  8,  9, 10, 11, 12],
            [ 0, 14, 15, 16, 17, 18],
            [19, 20,  0, 22, 23, 24],
            [25, 26, 27, 28, 29, 30],
            [31, 32, 33, 34, 35, 36]
        ];
        $expected = [
            [ 0,  2,  0,  4,  5,  6],
            [ 0,  8,  0, 10, 11, 12],
            [ 0,  0,  0,  0,  0,  0],
            [ 0,  0,  0,  0,  0,  0],
            [ 0, 26,  0, 28, 29, 30],
            [ 0, 32,  0, 34, 35, 36]
        ];
        ZeroMatrix::zero($matrix);
        $this->assertEquals($expected, $matrix);
    }

    public function testZeroMatrixWithZeroedTopRowAndLeftColumn() {
        $matrix = [
            [ 1,  2,  3,  4,  5,  0],
            [ 7,  8,  9, 10, 11, 12],
            [ 0, 14, 15, 16, 17, 18],
            [19, 20,  0, 22, 23, 24],
            [25, 26, 27, 28, 29, 30],
            [31, 32, 33, 34, 35, 36]
        ];
        $expected = [
            [ 0,  0,  0,  0,  0,  0],
            [ 0,  8,  0, 10, 11,  0],
            [ 0,  0,  0,  0,  0,  0],
            [ 0,  0,  0,  0,  0,  0],
            [ 0, 26,  0, 28, 29,  0],
            [ 0, 32,  0, 34, 35,  0]
        ];
        ZeroMatrix::zero($matrix);
        $this->assertEquals($expected, $matrix);
    }

    public function testZeroMatrixWithZeroOrigin() {
        $matrix = [
            [ 0,  2,  3,  4,  5,  6],
            [ 7,  8,  9, 10, 11, 12],
            [13, 14, 15, 16, 17, 18],
            [19, 20, 21, 22, 23, 24],
            [25, 26, 27, 28, 29, 30],
            [31, 32, 33, 34, 35, 36]
        ];
        $expected = [
            [ 0,  0,  0,  0,  0,  0],
            [ 0,  8,  9, 10, 11, 12],
            [ 0, 14, 15, 16, 17, 18],
            [ 0, 20, 21, 22, 23, 24],
            [ 0, 26, 27, 28, 29, 30],
            [ 0, 32, 33, 34, 35, 36]
        ];
        ZeroMatrix::zero($matrix);
        $this->assertEquals($expected, $matrix);
    }
}
