<?php
require_once __DIR__ . '/../../lib/BinaryTreeNode.php';

class CommonAncestorResult {
    private $node;
    private $coverCount;

    public function __construct(BinaryTreeNode $node, $coverCount) {
        $this->node = $node;
        $this->coverCount = $coverCount;
    }

    public function getNode() {
        return $this->node;
    }

    public function getCoverCount() {
        return $this->coverCount;
    }
}