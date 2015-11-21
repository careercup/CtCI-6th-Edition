<?php
require_once __DIR__ . '/../../../src/chapter08/question8.04/PowerSet.php';

class PowerSetTest extends PHPUnit_Framework_TestCase {

    public function testGetSubsetsWithZeroElements() {
        $set = [];
        $subsets = PowerSet::getSubsets($set);
        $expected = [ [] ];
        $this->assertEquals($expected, $subsets);
    }

    public function testGetSubsetsWithOneElement() {
        $set = [ 'a' ];
        $subsets = PowerSet::getSubsets($set);
        $expected = [ [], [ 'a' ] ];
        $this->assertEquals($expected, $subsets);
    }

    public function testGetSubsetsWithTwoElements() {
        $set = [ 'a', 'b' ];
        $subsets = PowerSet::getSubsets($set);
        $expected = [ [], [ 'a' ], [ 'b' ], [ 'a', 'b' ] ];
        $this->assertEquals($expected, $subsets);
    }

    public function testGetSubsetsWithThreeElements() {
        $set = [ 'a', 'b', 'c' ];
        $subsets = PowerSet::getSubsets($set);
        $expected = [
            [],
            [ 'a' ],
            [ 'b' ],
            [ 'a', 'b' ],
            [ 'c' ],
            [ 'a', 'c' ],
            [ 'b', 'c' ],
            [ 'a', 'b', 'c' ]
        ];
        $this->assertEquals($expected, $subsets);
    }

    public function testGetSubsetsWithTenElements() {
        $set = [ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' ];
        $expectedNumberOfSubsets = pow(2, count($set));
        $subsets = PowerSet::getSubsets($set);
        $this->assertEquals($expectedNumberOfSubsets, count($subsets));
    }
}
