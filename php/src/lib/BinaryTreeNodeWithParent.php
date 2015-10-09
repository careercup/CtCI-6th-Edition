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

    public function setParent(BinaryTreeNodeWithParent $parent=null) {
        $this->parent = $parent;
    }

    public function setLeft(BinaryTreeNode $left=null) {
        if ($left !== null && !($left instanceof BinaryTreeNodeWithParent)) {
            throw new InvalidArgumentException('When building a binary tree with parent references, all nodes must be instances of BinaryTreeNodeWithParent');
        }
        $oldLeft = $this->getLeft();
        if ($oldLeft !== null) {
            $oldLeft->setParent(null);
        }
        parent::setLeft($left);
        if ($left !== null) {
            $left->setParent($this);
        }
    }

    public function setRight(BinaryTreeNode $right=null) {
        if ($right !== null && !($right instanceof BinaryTreeNodeWithParent)) {
            throw new InvalidArgumentException('When building a binary tree with parent references, all nodes must be instances of BinaryTreeNodeWithParent');
        }
        $oldRight = $this->getRight();
        if ($oldRight !== null) {
            $oldRight->setParent(null);
        }
        parent::setRight($right);
        if ($right !== null) {
            $right->setParent($this);
        }
    }
}