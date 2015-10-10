<?php
require_once __DIR__ . '/../../lib/BinaryTreeNodeWithParent.php';

class BinaryTreeNodeWithRandomSelection extends BinaryTreeNodeWithParent {
    private $nodeCount;

    public function __construct($data) {
        parent::__construct($data);
        $this->nodeCount = 1;
    }

    public function setLeft(BinaryTreeNode $left=null) {
        $oldLeft = $this->getLeft();
        $delta = ($oldLeft !== null ? -$oldLeft->getNodeCount() : 0) + ($left !== null ? $left->getNodeCount() : 0);
        parent::setLeft($left);
        $this->updateNodeCount($delta);
    }

    public function setRight(BinaryTreeNode $right=null) {
        $oldRight = $this->getRight();
        $delta = ($oldRight !== null ? -$oldRight->getNodeCount() : 0) + ($right !== null ? $right->getNodeCount() : 0);
        parent::setRight($right);
        $this->updateNodeCount($delta);
    }

    public function getNodeCount() {
        return $this->nodeCount;
    }

    protected function updateNodeCount($delta) {
        if ($delta === 0) {
            return;
        }
        $this->nodeCount += $delta;
        $parent = $this->getParent();
        if ($parent !== null) {
            $parent->updateNodeCount($delta);
        }
    }

    public function insert($data) {
        $thisData = $this->getData();
        if ($data < $thisData) {
            $left = $this->getLeft();
            if ($left !== null) {
                return $left->insert($data);
            } else {
                $node = new BinaryTreeNodeWithRandomSelection($data);
                $this->setLeft($node);
                return $node;
            }
        } elseif ($data > $thisData) {
            $right = $this->getRight();
            if ($right !== null) {
                return $right->insert($data);
            } else {
                $node = new BinaryTreeNodeWithRandomSelection($data);
                $this->setRight($node);
                return $node;
            }
        }
        return null;
    }

    /**
     * see http://www.algolist.net/Data_structures/Binary_search_tree/Removal
     */
    public function delete($data) {
        $node = $this->find($data);
        if ($node === null) {
            return false;
        }
        $parent = $node->getParent();
        $leftChild = $node->getLeft();
        $rightChild = $node->getRight();

        $node->setLeft(null);
        $node->setRight(null);

        if ($leftChild !== null) {
            if ($rightChild !== null) {
                $rightTreeMin = $rightChild->min();
                $rightTreeMinParent = $rightTreeMin->getParent();
                if ($rightTreeMinParent !== null) {
                    $rightTreeMinParent->replace($rightTreeMin);
                }
                $parent->replace($node, $rightTreeMin);
                $rightTreeMin->setLeft($leftChild);
                if ($rightTreeMin->getData() !== $rightChild->getData()) {
                    $rightTreeMin->setRight($rightChild);
                }
            } else {
                $parent->replace($node, $leftChild);
            }
        } else {
            $parent->replace($node, $rightChild);
        }
        return true;
    }

    protected function replace(BinaryTreeNodeWithParent $oldNode, BinaryTreeNodeWithParent $newNode=null) {
        $data = $oldNode->getData();
        $left = $this->getLeft();
        if ($left !== null && $left->getData() === $data) {
            $this->setLeft($newNode);
        } else {
            $right = $this->getRight();
            if ($right !== null && $right->getData() === $data) {
                $this->setRight($newNode);
            } else {
                throw new InvalidArgumentException('Node containing ' . $data . ' is neither the left nor right child of node containing ' . $this->getData());
            }
        }
    }

    public function find($data) {
        $thisData = $this->getData();
        if ($data < $thisData) {
            $left = $this->getLeft();
            if ($left !== null) {
                return $left->find($data);
            }
        } elseif ($data > $thisData) {
            $right = $this->getRight();
            if ($right !== null) {
                return $right->find($data);
            }
        } elseif ($data == $thisData) {
            return $this;
        }
        return null;
    }

    public function min() {
        $min = $this;
        while (($left = $min->getLeft()) !== null) {
            $min = $left;
        }
        return $min;
    }

    public function max() {
        $max = $this;
        while (($right = $max->getRight()) !== null) {
            $max = $right;
        }
        return $max;
    }

    public function getRandomNode() {
        $left = parent::getLeft();
        $right = parent::getRight();

        $leftNodeCount = $left !== null ? $left->getNodeCount() : 0;
        $rightNodeCount = $right !== null ? $right->getNodeCount() : 0;

        $random = mt_rand(-$leftNodeCount, $rightNodeCount);
        if ($random < 0) {
            return $left->getRandomNode();
        } elseif ($random > 0) {
            return $right->getRandomNode();
        }
        // $random == 0
        return $this;
    }
}