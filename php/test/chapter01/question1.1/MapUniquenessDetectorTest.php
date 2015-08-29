<?php
require_once __DIR__ . '/../../../src/chapter01/question1.1/MapUniquenessDetector.php';

class MapUniquenessDetectorTest extends PHPUnit_Framework_TestCase {
    public function testIsUnique() {
        $this->assertTrue(MapUniquenessDetector::isUnique("abcdefg"));
        $this->assertFalse(MapUniquenessDetector::isUnique("level"));
    }
}
