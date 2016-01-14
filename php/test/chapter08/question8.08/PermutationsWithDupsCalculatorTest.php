<?php
require_once __DIR__ . '/../../../src/chapter08/question8.08/PermutationsWithDupsCalculator.php';

class PermutationsWithDupsCalculatorTest extends PHPUnit_Framework_TestCase {

    public function testGetPermutationsWithDups() {
        $permutations = PermutationsWithDupsCalculator::getPermutations('abb');
        $expected = [ 'abb', 'bab', 'bba' ];
        $this->assertEquals($expected, $permutations);
    }

    public function testGetPermutationsNoDups() {
        $permutations = PermutationsWithDupsCalculator::getPermutations('abc');
        $expected = [ 'abc', 'acb', 'bac', 'bca', 'cab', 'cba' ];
        $this->assertEquals($expected, $permutations);
    }

    public function testGetPermutationsWithThreeBs() {
        $permutations = PermutationsWithDupsCalculator::getPermutations('abbbc');
        $this->assertEquals(20, count($permutations));
        $uniquePermutations = [];
        foreach ($permutations as $permutation) {
            $this->assertFalse(isset($uniquePermutations[$permutation]));
            $uniquePermutations[$permutation] = 1;
        }
    }

    public function testGetPermutationsWithLotsOfAs() {
        $lotsOfAs = 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa';
        $permutations = PermutationsWithDupsCalculator::getPermutations($lotsOfAs);
        $expected = [ $lotsOfAs ];
        $this->assertEquals($expected, $permutations);
    }
}
