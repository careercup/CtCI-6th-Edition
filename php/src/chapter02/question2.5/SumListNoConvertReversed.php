<?php
require_once __DIR__ . '/../../lib/DoublyLinkedListNode.php';

class SumListNoConvertReversed {
    public static function sum(Node $n1, Node $n2) {
        $head = $tail = null;

        $n1Length = self::getLinkedListSize($n1);
        $n2Length = self::getLinkedListSize($n2);

        $maxLength = max($n1Length, $n2Length);

        $n1Offset = $maxLength - $n1Length;
        $n2Offset = $maxLength - $n2Length;

        while ($n1 !== null || $n2 !== null) {
            $sum = 0;

            if ($n1Offset > 0) {
                $n1Offset--;
            } else {
                $sum += $n1->getData();
                $n1 = $n1->getNext();
            }

            if ($n2Offset > 0) {
                $n2Offset--;
            } else {
                $sum += $n2->getData();
                $n2 = $n2->getNext();
            }

            self::addDigitToLinkedList($head, $tail, $sum);
        }
        return $head;
    }

    public static function addDigitToLinkedList(
            DoublyLinkedListNode &$head = null, DoublyLinkedListNode &$tail = null, $number) {
        $digit = $number % 10;
        if ($number >= 10) {
            $carry = ($number - $digit) / 10;
            if ($tail !== null) {
                $previousDigit = $tail->getData();
                $tail = $tail->getPrevious();
                if ($tail !== null) {
                    $tail->setNext(null);
                } else {
                    $head = null;
                }
            } else {
                $previousDigit = 0;
            }
            self::addDigitToLinkedList($head, $tail, $previousDigit + $carry);
        }
        $node = new DoublyLinkedListNode($digit);
        if ($tail !== null) {
            $tail->setNext($node);
            $node->setPrevious($tail);
            $tail = $node;
        } else {
            $head = $tail = $node;
        }
    }

    public static function getLinkedListSize(Node $node) {
        $size = 0;
        while ($node !== null) {
            $size++;
            $node = $node->getNext();
        }
        return $size;
    }
}
