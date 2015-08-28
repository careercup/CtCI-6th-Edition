<?php
$baseDir = __DIR__ . '/../../../src/chapter02/question2.6';
require_once $baseDir . '/LinkedListPalindromeChecker.php';

class LinkedListPalindromeCheckerTest extends PHPUnit_Framework_TestCase {

    public function testIsPalindrome() {
        $list = new LinkedList();
        $list->add("A");
        $list->add("B");
        $list->add("C");
        $list->add("D");
        $list->add("C");
        $list->add("B");
        $list->add("A");
        $this->assertTrue(LinkedListPalindromeChecker::isPalindrome($list));
    }

    public function testIsNotPalindrome() {
        $list = new LinkedList();
        $list->add("A");
        $list->add("B");
        $list->add("C");
        $list->add("D");
        $this->assertFalse(LinkedListPalindromeChecker::isPalindrome($list));
    }
}
