<?php
require_once __DIR__ . '/../../../src/chapter01/question1.2/HashMapStringPermutationChecker.php';

class HashMapStringPermutationCheckerTest extends PHPUnit_Framework_TestCase {
    public function testIsPermutation() {
        $this->assertTrue(HashMapStringPermutationChecker::isPermutation("abcdefgg", "gabfdecg"));
        $this->assertFalse(HashMapStringPermutationChecker::isPermutation("bad", "owl"));
        $this->assertFalse(HashMapStringPermutationChecker::isPermutation("different", "lengths"));
    }
}
