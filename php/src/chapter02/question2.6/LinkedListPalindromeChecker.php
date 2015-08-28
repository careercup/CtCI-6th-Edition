<?php
require_once __DIR__ . '/../../lib/LinkedList.php';

class LinkedListPalindromeChecker {
    public static function isPalindrome(LinkedList $list) {
        if ($list->getSize() < 2) {
            return true;
        }
        $first = $list->removeFirst();
        $last = $list->removeLast();
        if ($first !== $last) {
            return false;
        }
        return self::isPalindrome($list);
    }
}
