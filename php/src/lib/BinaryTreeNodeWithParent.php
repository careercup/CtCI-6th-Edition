<?php
require_once __DIR__ . DIRECTORY_SEPARATOR . 'BinaryTreeNode.php';

class BinaryTreeNodeWithParent extends BinaryTreeNode {
    protected $parent;

    public function __construct($data) {
        parent::__construct($data);
    }

    public function getParent() {
        return $this->parent;
    }

    public function setParent(BinaryTreeNodeWithParent $parent) {
        $this->parent = $parent;
    }

    public function setLeft(BinaryTreeNode $left) {
        if (!($left instanceof BinaryTreeNodeWithParent)) {
            throw new InvalidArgumentException('When building a binary tree with parent references, all nodes must be instances of BinaryTreeNodeWithParent');
        }
        parent::setLeft($left);
        $left->setParent($this);
    }

    public function setRight(BinaryTreeNode $right) {
        if (!($right instanceof BinaryTreeNodeWithParent)) {
            throw new InvalidArgumentException('When building a binary tree with parent references, all nodes must be instances of BinaryTreeNodeWithParent');
        }
        parent::setRight($right);
        $right->setParent($this);
    }
}