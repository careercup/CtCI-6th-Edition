<?php
require_once __DIR__ . '/../../../src/chapter01/question1.9/StringRotationChecker.php';

class StringRotationCheckerTest extends PHPUnit_Framework_TestCase {

    public function testIsRotation() {
        $this->assertTrue(StringRotationChecker::isRotation('waterbottle', 'erbottlewat'));
        $this->assertTrue(StringRotationChecker::isRotation('erbottlewat', 'waterbottle'));
    }

    public function testIsNotRotation() {
        $this->assertFalse(StringRotationChecker::isRotation('winter', 'summer'));
        $this->assertFalse(StringRotationChecker::isRotation('summer', 'winter'));
    }

    public function testIsNotRotationBecauseLengthsAreDifferent() {
        $this->assertFalse(StringRotationChecker::isRotation('spring', 'fall'));
        $this->assertFalse(StringRotationChecker::isRotation('fall', 'spring'));
    }
}
