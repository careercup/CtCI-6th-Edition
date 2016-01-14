<?php
require_once __DIR__ . '/../../../src/chapter16/question16.24/PairSumFinder.php';

class PairSumFinderTest extends PHPUnit_Framework_TestCase {

    public function testFindPairsWithSumOf14() {
        $arr = [ 1, 10, 4, -1, 9, 2, 11, 80, 14, 15, 0, 12, 5, 9, -70, 5 ];
        $pairs = PairSumFinder::findPairsWithSum(14, $arr);
        $expectedPairs = [
            [ 10, 4 ],
            [ -1, 15 ],
            [ 14, 0 ],
            [ 2, 12 ],
            [ 9, 5 ]
        ];
        $this->assertEquals($expectedPairs, $pairs);
    }

    public function testFindPairsWithSumOf12() {
        $arr = [ 9, 3, 6, 5, 7, 7, -1, 13, 14, -2, 12, 0 ];
        $pairs = PairSumFinder::findPairsWithSum(12, $arr);
        $expectedPairs = [
            [ 9, 3 ],
            [ 5, 7 ],
            [ -1, 13 ],
            [ 14, -2 ],
            [ 12, 0 ]
        ];
        $this->assertEquals($expectedPairs, $pairs);
    }
}
