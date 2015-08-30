<?php
require_once __DIR__ . '/../../../src/chapter01/question1.5/OneAwayChecker.php';

class OneAwayCheckerTest extends PHPUnit_Framework_TestCase {

    public function testIsOneOrZeroAway1() {
        $this->assertTrue(OneAwayChecker::isOneOrZeroAway('pale', 'ple'));
    }

    public function testIsOneOrZeroAway2() {
        $this->assertTrue(OneAwayChecker::isOneOrZeroAway('pales', 'pale'));
    }

    public function testIsOneOrZeroAway3() {
        $this->assertTrue(OneAwayChecker::isOneOrZeroAway('pale', 'pales'));
    }

    public function testIsOneOrZeroAway4() {
        $this->assertTrue(OneAwayChecker::isOneOrZeroAway('pale', 'bale'));
    }

    public function testIsOneOrZeroAway5() {
        $this->assertFalse(OneAwayChecker::isOneOrZeroAway('pale', 'bake'));
    }

    public function testIsOneOrZeroAway6() {
        $this->assertFalse(OneAwayChecker::isOneOrZeroAway('pale', 'baker'));
    }

    public function testIsOneOrZeroAway7() {
        $this->assertTrue(OneAwayChecker::isOneOrZeroAway('pale', 'pale'));
    }

    public function testIsOneOrZeroAway8() {
        $this->assertFalse(OneAwayChecker::isOneOrZeroAway('pale', 'paleolithic'));
    }
}
