<?php
require_once __DIR__ . '/../../lib/Node.php';

class SumList {
    public static function sum(Node $n1, Node $n2) {
        $sum = self::toInteger($n1) + self::toInteger($n2);
        return self::toLinkedListOfDigits($sum);
    }

    public static function toInteger(Node $digits) {
        $sum = 0;
        $base = 1;
        $node = $digits;
        do {
            $digit = $node->getData();
            $sum += $base * $digit;
            $base *= 10;
        } while (($node = $node->getNext()) !== null);
        return $sum;
    }

    public static function toLinkedListOfDigits($number) {
        $head = null;
        $lastNode = null;
        $base = 1;
        while ($number > 0) {
            $nextBase = $base * 10;
            $remainder = $number % $nextBase;
            $digit = new Node($remainder / $base);
            if ($head === null) {
                $head = $digit;
            } else {
                $lastNode->setNext($digit);
            }
            $lastNode = $digit;
            $number -= $remainder;
            $base = $nextBase;
        }
        return $head;
    }
}
