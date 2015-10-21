<?php
require_once __DIR__ . '/../../../src/chapter05/question5.5/Debugger.php';

class DebuggerTest extends PHPUnit_Framework_TestCase {

    public function testIsPowerOfTwo() {
        $powersOfTwo = [ 1, 2, 4, 8, 16, 32, 64 ];
        for ($i=1; $i<=64; $i++) {
            if (in_array($i, $powersOfTwo)) {
                $this->assertTrue(Debugger::isPowerOfTwo($i));
            } else {
                $this->assertFalse(Debugger::isPowerOfTwo($i));
            }
        }
    }
}
