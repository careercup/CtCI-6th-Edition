<?php
require_once __DIR__ . '/../../lib/Node.php';

class DoublePointerDupRemover {
    public static function removeDups(Node $node) {
        $pointer1 = $node;
        while ($pointer1 !== null) {
            $previousPointer = $pointer1;
            $pointer2 = $pointer1->getNext();
            while ($pointer2 !== null) {
                if ($pointer1->getData() == $pointer2->getData()) {
                    // remove the node pointed at by $pointer2
                    $previousPointer->setNext($pointer2->getNext());
                    $pointer2 = $previousPointer;
                } else {
                    $previousPointer = $pointer2;
                }
                $pointer2 = $pointer2->getNext();
            }
            $pointer1 = $pointer1->getNext();
        }
    }
}
