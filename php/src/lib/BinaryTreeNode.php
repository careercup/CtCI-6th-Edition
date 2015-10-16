<?php

class BinaryTreeNode {
    protected $data;
    protected $left;
    protected $right;

    public function __construct($data) {
        $this->data = $data;
    }

    public function getData() {
        return $this->data;
    }

    public function setData($data) {
        $this->data = $data;
    }

    public function getLeft() {
        return $this->left;
    }

    public function setLeft(BinaryTreeNode $left=null) {
        $this->left = $left;
    }

    public function getRight() {
        return $this->right;
    }

    public function setRight(BinaryTreeNode $right=null) {
        $this->right = $right;
    }

    public function __toString() {
        return $this->data != null ? (string) $this->data : null;
    }
}
