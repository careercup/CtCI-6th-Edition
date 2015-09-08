<?php
require_once __DIR__ . '/../../lib/Node.php';

class BackwardScanningDupRemover {
    public static function removeDups(Node $node) {
        $pointer1 = $node;
        $lastNode = null;
        $i = 0;
        while ($pointer1 !== null) {
            $pointer2 = $node;
            $j = 0;
            $foundDup = false;
            while($j < $i) {
                if ($pointer2->getData() === $pointer1->getData()) {
                    // remove node @ $pointer1
                    $lastNode->setNext($pointer1->getNext());
                    $foundDup = true;
                    break;
                }
                $j++;
                $pointer2 = $pointer2->getNext();
            }
            if (!$foundDup) {
                $lastNode = $pointer1;
                $i++;
            }
            $pointer1 = $pointer1->getNext();
        }
    }
}