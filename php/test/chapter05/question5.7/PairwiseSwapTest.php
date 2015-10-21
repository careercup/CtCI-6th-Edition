<?php
require_once __DIR__ . '/../../../src/chapter05/question5.7/PairwiseSwap.php';

class PairwiseSwapTest extends PHPUnit_Framework_TestCase {

    public function testSwap() {
        $this->assertEquals(5, PairwiseSwap::swap(10));
        $this->assertEquals(15, PairwiseSwap::swap(15));
        $this->assertEquals(0, PairwiseSwap::swap(0));
        $this->assertEquals(31, PairwiseSwap::swap(47));
    }
}
