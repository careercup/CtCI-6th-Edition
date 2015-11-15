<?php
require_once __DIR__ . '/../../../src/chapter08/question8.01/TripleStep.php';

class TripleStepTest extends PHPUnit_Framework_TestCase {

    public function testGetNumberOfWaysToClimbZeroSteps() {
        // There is exactly 1 way to climb zero steps. i.e. not to do it
        $this->assertEquals(1, TripleStep::getNumberOfWaysToClimbSteps(0));
    }

    public function testGetNumberOfWaysToClimbOneStep() {
        $waysToClimbOneStep = [ [1] ];
        $this->assertEquals(count($waysToClimbOneStep), TripleStep::getNumberOfWaysToClimbSteps(1));
    }

    public function testGetNumberOfWaysToClimbTwoSteps() {
        $waysToClimbTwoSteps = [
            [ 1, 1 ],
            [ 2 ]
        ];
        $this->assertEquals(count($waysToClimbTwoSteps), TripleStep::getNumberOfWaysToClimbSteps(2));
    }

    public function testGetNumberOfWaysToClimbThreeSteps() {
        $waysToClimbThreeSteps = [
            [ 1, 1, 1 ],
            [ 1, 2 ],
            [ 2, 1 ],
            [ 3 ],
        ];
        $this->assertEquals(count($waysToClimbThreeSteps), TripleStep::getNumberOfWaysToClimbSteps(3));
    }

    public function testGetNumberOfWaysToClimbFourSteps() {
        $waysToClimbFourSteps = [
            [ 1, 1, 1, 1 ],
            [ 1, 1, 2 ],
            [ 1, 2, 1 ],
            [ 2, 1, 1 ],
            [ 2, 2 ],
            [ 1, 3 ],
            [ 3, 1 ]
        ];
        $this->assertEquals(count($waysToClimbFourSteps), TripleStep::getNumberOfWaysToClimbSteps(4));
    }

    public function testGetNumberOfWaysToClimbFiveSteps() {
        $waysToClimbFiveSteps = [
            [ 1, 1, 1, 1, 1 ],
            [ 1, 1, 1, 2 ],
            [ 1, 1, 2, 1 ],
            [ 1, 2, 1, 1 ],
            [ 2, 1, 1, 1 ],
            [ 1, 2, 2 ],
            [ 2, 1, 2 ],
            [ 2, 2, 1 ],
            [ 1, 1, 3 ],
            [ 1, 3, 1 ],
            [ 3, 1, 1 ],
            [ 2, 3 ],
            [ 3, 2 ]
        ];
        $this->assertEquals(count($waysToClimbFiveSteps), TripleStep::getNumberOfWaysToClimbSteps(5));
    }

    public function testGetNumberOfWaysToClimbSixSteps() {
        $waysToClimbSixSteps = [
            [ 1, 1, 1, 1, 1, 1 ],
            [ 1, 1, 1, 1, 2 ],
            [ 1, 1, 1, 2, 1 ],
            [ 1, 1, 2, 1, 1 ],
            [ 1, 2, 1, 1, 1 ],
            [ 2, 1, 1, 1, 1 ],
            [ 1, 1, 2, 2 ],
            [ 1, 2, 2, 1 ],
            [ 2, 2, 1, 1 ],
            [ 1, 2, 1, 2 ],
            [ 2, 1, 2, 1 ],
            [ 2, 1, 1, 2 ],
            [ 1, 1, 1, 3 ],
            [ 1, 1, 3, 1 ],
            [ 1, 3, 1, 1 ],
            [ 3, 1, 1, 1 ],
            [ 1, 2, 3 ],
            [ 1, 3, 2 ],
            [ 2, 1, 3 ],
            [ 2, 3, 1 ],
            [ 3, 1, 2 ],
            [ 3, 2, 1 ],
            [ 2, 2, 2 ],
            [ 3, 3 ]
        ];
        $this->assertEquals(count($waysToClimbSixSteps), TripleStep::getNumberOfWaysToClimbSteps(6));
    }

    public function testGetNumberOfWaysToClimbTwentyFourSteps() {
        $this->assertEquals(1389537, TripleStep::getNumberOfWaysToClimbSteps(24));
    }
}
