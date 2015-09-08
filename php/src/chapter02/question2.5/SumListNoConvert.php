<?php
require_once __DIR__ . '/../../lib/Node.php';

class SumListNoConvert {
    public static function sum(Node $n1, Node $n2) {
        $head = $tail = null;
        $carry = 0;
        while ($n1 !== null || $n2 !== null) {
            $sum = $carry;
            if ($n1 !== null) {
                $sum += $n1->getData();
                $n1 = $n1->getNext();
            }
            if ($n2 !== null) {
                $sum += $n2->getData();
                $n2 = $n2->getNext();
            }
            if ($sum >= 10) {
                $digit = $sum % 10;
                $node = new Node($digit);
                if ($head === null) {
                    $head = $tail = $node;
                } else {
                    $tail->setNext($node);
                    $tail = $node;
                }
                $carry = ($sum - $digit) / 10;
            } else {
                $node = new Node($sum);
                if ($head === null) {
                    $head = $tail = $node;
                } else {
                    $tail->setNext($node);
                    $tail = $node;
                }
                $carry = 0;
            }
        }
        if ($carry > 0) {
            $node = new Node($carry);
            if ($head === null) {
                $head = $tail = $node;
            } else {
                $tail->setNext($node);
                $tail = $node;
            }
        }
        return $head;
    }
}
