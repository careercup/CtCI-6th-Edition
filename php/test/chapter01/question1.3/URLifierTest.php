<?php
require_once __DIR__ . '/../../../src/chapter01/question1.3/URLifier.php';

class URLifierTest extends PHPUnit_Framework_TestCase {
    public function testUrlify() {
        $str      = "Mr John Smith    ";
        $expected = "Mr%20John%20Smith";
        URLifier::urlify($str);
        $this->assertEquals($expected, $str);
    }

    public function testUrlifyWithNoSpaces() {
        $str      = "NoSpaces";
        $expected = "NoSpaces";
        URLifier::urlify($str);
        $this->assertEquals($expected, $str);
    }
}
