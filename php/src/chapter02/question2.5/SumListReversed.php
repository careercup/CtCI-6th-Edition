<?php
require_once __DIR__ . '/../../lib/Node.php';

class SumListReversed {
    public static function sum(Node $n1, Node $n2) {
        $sum = self::toInteger($n1) + self::toInteger($n2);
        return self::toLinkedListOfDigits($sum);
    }

    public static function toInteger(Node $digits) {
        $sum = 0;
        $node = $digits;
        do {
            $digit = $node->getData();
            $sum = $sum * 10 + $digit;
        } while (($node = $node->getNext()) !== null);
        return $sum;
    }

    public static function toLinkedListOfDigits($number) {
        $head = null;
        $base = 1;
        while ($number > 0) {
            $nextBase = $base * 10;
            $remainder = $number % $nextBase;
            $digit = new Node($remainder / $base);
            $digit->setNext($head);
            $head = $digit;
            $number -= $remainder;
            $base = $nextBase;
        }
        return $head;
    }
}
