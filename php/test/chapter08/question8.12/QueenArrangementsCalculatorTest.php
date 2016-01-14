<?php
require_once __DIR__ . '/../../../src/chapter08/question8.12/QueenArrangementsCalculator.php';

class QueenArrangementsCalculatorTest extends PHPUnit_Framework_TestCase {

    public function testGetQueenArrangements() {
        $arrangements = QueenArrangementsCalculator::getQueenArrangements();
        $this->assertEquals(92, count($arrangements));
    }

    public function testPrintAllWaysToArrangeEightQueens() {
        ob_start();
        QueenArrangementsCalculator::printAllWaysToArrangeEightQueens();
        $output = ob_get_clean();
        $expectedOutput = file_get_contents(__DIR__ . DIRECTORY_SEPARATOR . 'expected_output.txt');
        $this->assertEquals($expectedOutput, $output);
    }
}
