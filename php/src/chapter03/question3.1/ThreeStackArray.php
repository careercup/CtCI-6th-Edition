<?php

class ThreeStackArray {
    const STACK_COUNT = 3;
    private $array;
    private $arraySize;
    private $startIndexes;
    private $endIndexes;
    private $total;

    public function __construct($arraySize=30) {
        $this->array = [];
        $this->arraySize = $arraySize;
        // initialize array
        for ($i=0; $i<$arraySize; $i++) {
            $this->array[$i] = null;
        }
        $size = $arraySize / self::STACK_COUNT;
        $this->startIndexes = [];
        $this->endIndexes = [];
        for ($i=0; $i<self::STACK_COUNT; $i++) {
            $this->startIndexes[$i] = $i * $size;
            $this->endIndexes[$i] = $this->startIndexes[$i];
        }
        $this->total=0;
    }

    public function push($stackIndex, $data) {
        if ($this->total >= $this->arraySize) {
            throw new RuntimeException('No space left');
        }
        if ($this->getFreeSlotCount($stackIndex) == 0) {
            $nextStackIndex = ($stackIndex + 1) % self::STACK_COUNT;
            $previousStackIndex = $stackIndex == 0 ? self::STACK_COUNT - 1 : $stackIndex - 1;

            $nextStackFreeSlotCount = $this->getFreeSlotCount($nextStackIndex);
            $previousStackFreeSlotCount = $this->getFreeSlotCount($previousStackIndex);

            if ($nextStackFreeSlotCount > $previousStackFreeSlotCount) {
                $delta = $nextStackFreeSlotCount < 2 ? 1 : (int) ($nextStackFreeSlotCount / 2);
                $this->moveStackForwards($nextStackIndex, $delta);
            } else {
                $delta = $previousStackFreeSlotCount < 2 ? 1 : (int) ($previousStackFreeSlotCount / 2);
                $this->moveStackBackwards($stackIndex, $delta);
            }
        }
        $index = $this->endIndexes[$stackIndex];
        $this->endIndexes[$stackIndex] = $this->adjust($this->endIndexes[$stackIndex] + 1);
        $this->total++;
        $this->array[$index] = $data;
    }

    public function pop($stackIndex) {
        if ($this->startIndexes[$stackIndex] == $this->endIndexes[$stackIndex]) {
            return null;
        }
        $this->endIndexes[$stackIndex] = $this->adjust($this->endIndexes[$stackIndex] - 1);
        $index = $this->endIndexes[$stackIndex];
        $data = $this->array[$index];
        $this->array[$index] = null; // garbage collection
        $this->total--;
        return $data;
    }

    public function getSize($stackIndex) {
        return $this->adjust($this->endIndexes[$stackIndex] - $this->startIndexes[$stackIndex]);
    }

    public function isEmpty($stackIndex) {
        return $this->getSize($stackIndex) == 0;
    }

    public function getTotal() {
        return $this->total;
    }

    public function getFreeSlotCount($stackIndex) {
        $endIndex = $this->endIndexes[$stackIndex];
        $nextStackIndex = ($stackIndex + 1) % self::STACK_COUNT;
        $startIndexOfNextStack = $this->startIndexes[$nextStackIndex];
        return $this->adjust($startIndexOfNextStack - $endIndex);
    }

    protected function moveStackBackwards($stackIndex, $steps) {
        $size = $this->getSize($stackIndex);
        $this->startIndexes[$stackIndex] = $this->adjust($this->startIndexes[$stackIndex] - $steps);
        $this->endIndexes[$stackIndex] = $this->adjust($this->endIndexes[$stackIndex] - $steps);
        for ($i = $this->startIndexes[$stackIndex], $stop = $i + $size; $i < $stop; $i++) {
            $oldIndex = $this->adjust($i + $steps);
            $newIndex = $this->adjust($i);
            $this->array[$newIndex] = $this->array[$oldIndex];
            $this->array[$oldIndex] = null; // garbage collection
        }
    }

    protected function moveStackForwards($stackIndex, $steps) {
        $size = $this->getSize($stackIndex);
        $this->startIndexes[$stackIndex] = $this->adjust($this->startIndexes[$stackIndex] + $steps);
        $this->endIndexes[$stackIndex] = $this->adjust($this->endIndexes[$stackIndex] + $steps);
        for ($i = $this->endIndexes[$stackIndex] - 1, $stop = $i - $size; $i > $stop; $i--) {
            $oldIndex = $this->adjust($i - $steps);
            $newIndex = $this->adjust($i);
            $this->array[$newIndex] = $this->array[$oldIndex];
            $this->array[$oldIndex] = null; // garbage collection
        }
    }

    protected function adjust($index) {
        if ($index < 0) {
            return $index + $this->arraySize;
        } elseif ($index >= $this->arraySize) {
            return $index % $this->arraySize;
        }
        return $index;
    }
}