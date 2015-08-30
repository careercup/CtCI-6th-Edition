<?php
require_once __DIR__ . '/../../../src/chapter01/question1.4/PalindromePermutationChecker.php';

class PalindromePermutationCheckerTest extends PHPUnit_Framework_TestCase {

    public function testIsPalindromePermutation() {
        $this->assertTrue(PalindromePermutationChecker::isPalindromePermutation("Tact Coa"));
    }

    public function testIsNotPalindromePermutation() {
        $this->assertFalse(PalindromePermutationChecker::isPalindromePermutation("aaabbccc"));
    }
}
