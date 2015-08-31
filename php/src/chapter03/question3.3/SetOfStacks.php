<?php
require_once __DIR__ . DIRECTORY_SEPARATOR . 'SizedStack.php';
require_once __DIR__ . DIRECTORY_SEPARATOR . 'RandomAccessSizedStack.php';

class SetOfStacks {
    private $stacks;
    private $stackSize;

    public function __construct($stackSize) {
        $this->stackSize = $stackSize;
        $this->stacks = new RandomAccessSizedStack();
    }

    public function push($value) {
        $currentStack = $this->stacks->peek();
        if ($currentStack === null || $currentStack->getSize() >= $this->stackSize) {
            $currentStack = new SizedStack();
            $this->stacks->push($currentStack);
        }
        $currentStack->push($value);
    }

    public function pop() {
        $currentStack = $this->stacks->peek();
        if ($currentStack === null) {
            return null;
        }
        $value = $currentStack->pop();
        while ($currentStack->getSize() <= 0) {
            $this->stacks->pop();
            $currentStack = $this->stacks->peek();
            if ($currentStack === null) {
                break;
            }
        }
        return $value;
    }

    public function peek() {
        $currentStack = $this->stacks->peek();
        if ($currentStack === null) {
            return null;
        }
        return $currentStack->peek();
    }

    public function popAt($index) {
        $subStack = $this->stacks->peekAt($index);
        return $subStack->pop();
    }

    public function getStackCount() {
        return $this->stacks->getSize();
    }
}
