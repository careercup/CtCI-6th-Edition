<?php
require_once __DIR__ . '/../../../src/chapter16/question16.02/WordFrequencyCalculator.php';

class WordFrequencyCalculatorTest extends PHPUnit_Framework_TestCase {

    public function testGetFrequency() {
        $wordFrequencyCalculator = new WordFrequencyCalculator(__DIR__ . DIRECTORY_SEPARATOR . 'book.txt');
        $this->assertEquals(2, $wordFrequencyCalculator->getFrequency("book"));
        $this->assertEquals(1, $wordFrequencyCalculator->getFrequency("a"));
        $this->assertEquals(1, $wordFrequencyCalculator->getFrequency("it's"));
        $this->assertEquals(1, $wordFrequencyCalculator->getFrequency("you'll"));
        $this->assertEquals(2, $wordFrequencyCalculator->getFrequency("FOR"));
        $this->assertEquals(1, $wordFrequencyCalculator->getFrequency("Testing"));
        $this->assertEquals(0, $wordFrequencyCalculator->getFrequency("untested"));
    }

    public function testFileNotFound() {
        $this->setExpectedException('RuntimeException');
        new WordFrequencyCalculator(__DIR__ . DIRECTORY_SEPARATOR . 'non-existent-file.txt');
    }
}
