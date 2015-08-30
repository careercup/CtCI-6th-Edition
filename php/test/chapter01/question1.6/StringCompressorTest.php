<?php
require_once __DIR__ . '/../../../src/chapter01/question1.6/StringCompressor.php';

class StringCompressorTest extends PHPUnit_Framework_TestCase {

    public function testCompress() {
        $this->assertEquals('a2b1c5a3', StringCompressor::compress('aabcccccaaa'));
    }

    public function testCompressWhenOriginalIsShorter() {
        // compressme is shorter than c1o1m1p1r1e1s2m1e1
        $this->assertEquals('compressme', StringCompressor::compress('compressme'));
    }

    public function testCompressWhenCompressedIsNotShorterButWeDontKnowThatUntilTheEnd() {
        // a3b1 is not shorter than aaab
        $this->assertEquals('aaab', StringCompressor::compress('aaab'));
    }

    public function testCompressWithOneAtEnd() {
        $this->assertEquals('a2b1c5a1', StringCompressor::compress('aabccccca'));
    }

    public function testCompressWithEmptyString() {
        $this->assertEquals('', StringCompressor::compress(''));
    }
}
