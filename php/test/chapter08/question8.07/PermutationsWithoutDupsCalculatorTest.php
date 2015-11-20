<?php
require_once __DIR__ . '/../../../src/chapter08/question8.07/PermutationsWithoutDupsCalculator.php';

class PermutationsWithoutDupsCalculatorTest extends PHPUnit_Framework_TestCase {

    public function testGetZeroLetterPermutations() {
        $permutations = PermutationsWithoutDupsCalculator::getPermutations('');
        $expected = [];
        $this->assertEquals($expected, $permutations);
    }

    public function testGetOneLetterPermutations() {
        $permutations = PermutationsWithoutDupsCalculator::getPermutations('a');
        $expected = [ 'a' ];
        $this->assertEquals($expected, $permutations);
    }

    public function testGetTwoLetterPermutations() {
        $permutations = PermutationsWithoutDupsCalculator::getPermutations('ab');
        $expected = [ 'ab', 'ba' ];
        $this->assertEquals($expected, $permutations);
    }

    public function testGetThreeLetterPermutations() {
        $permutations = PermutationsWithoutDupsCalculator::getPermutations('abc');
        $expected = [ 'abc', 'acb', 'bac', 'bca', 'cab', 'cba' ];
        $this->assertEquals($expected, $permutations);
    }

    public function testGetFourLetterPermutations() {
        $permutations = PermutationsWithoutDupsCalculator::getPermutations('abcd');
        $expected = [
            'abcd', 'abdc', 'acbd', 'acdb', 'adbc', 'adcb',
            'bacd', 'badc', 'bcad', 'bcda', 'bdac', 'bdca',
            'cabd', 'cadb', 'cbad', 'cbda', 'cdab', 'cdba',
            'dabc', 'dacb', 'dbac', 'dbca', 'dcab', 'dcba',
        ];
        $this->assertEquals($expected, $permutations);
    }
}
