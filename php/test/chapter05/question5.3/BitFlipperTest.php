<?php
require_once __DIR__ . '/../../../src/chapter05/question5.3/BitFlipper.php';

class BitFlipperTest extends PHPUnit_Framework_TestCase {

    public function testFlipBit() {
        $this->assertEquals(8, BitFlipper::flipBitToWin(1775));
        $this->assertEquals(6, BitFlipper::flipBitToWin(15 + 32 + pow(2, 31)));
        $this->assertEquals(3, BitFlipper::flipBitToWin(2 + 8 + 32 + 128));
        $this->assertEquals(2, BitFlipper::flipBitToWin(16));
        $this->assertEquals(3, BitFlipper::flipBitToWin(16 + 32));
        $this->assertEquals(3, BitFlipper::flipBitToWin(16 + 64));
        $this->assertEquals(2, BitFlipper::flipBitToWin(16 + 128));
        $this->assertEquals(1, BitFlipper::flipBitToWin(0));
        $this->assertEquals(2, BitFlipper::flipBitToWin(1));
        $this->assertEquals(2, BitFlipper::flipBitToWin(pow(2, 31)));
        $this->assertEquals(7, BitFlipper::flipBitToWin(
                4 + 8 + 16 + 64 + 128 + 1024 + 2048 + 4096 + 8192 + 32768 + 65536));
        $number = 0;
        for ($i=0; $i<BitFlipper::BIT_COUNT; $i++)  {
            $number += pow(2, $i);
        }
        $this->assertEquals(BitFlipper::BIT_COUNT, BitFlipper::flipBitToWin($number));
    }
}
