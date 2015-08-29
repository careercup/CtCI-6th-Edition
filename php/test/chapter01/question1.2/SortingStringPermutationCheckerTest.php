<?php
require_once __DIR__ . '/../../../src/chapter01/question1.2/SortingStringPermutationChecker.php';

class SortingStringPermutationCheckerTest extends PHPUnit_Framework_TestCase {
    public function testIsPermutation() {
        $this->assertTrue(SortingStringPermutationChecker::isPermutation("abcdefgg", "gabfdecg"));
        $this->assertFalse(SortingStringPermutationChecker::isPermutation("bad", "owl"));
        $this->assertFalse(SortingStringPermutationChecker::isPermutation("different", "lengths"));
    }
}
