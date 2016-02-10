<?php
require_once __DIR__ . '/../../../src/chapter05/question5.4/NextNumber.php';

class NextNumberTest extends PHPUnit_Framework_TestCase {

    public function testGetPreviousAndNextNumbersWithSameNumberOfOneBits() {
        $this->assertEquals([ 2, 8 ], NextNumber::getPreviousAndNextNumbersWithSameNumberOfOneBits(4));
        $this->assertEquals([ 3, 6 ], NextNumber::getPreviousAndNextNumbersWithSameNumberOfOneBits(5));
        $this->assertEquals([ 47, 59 ], NextNumber::getPreviousAndNextNumbersWithSameNumberOfOneBits(55));
        $this->assertEquals([ null, null ], NextNumber::getPreviousAndNextNumbersWithSameNumberOfOneBits(0));
        $this->assertEquals([ null, 23 ], NextNumber::getPreviousAndNextNumbersWithSameNumberOfOneBits(15));
        $this->assertEquals([ null, 95 ], NextNumber::getPreviousAndNextNumbersWithSameNumberOfOneBits(63));
    }
}
