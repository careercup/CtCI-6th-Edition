<?php

class Cell {
    private $bomb;
    private $flagged;
    private $hidden;
    private $surroundingBombCount;

    public function __construct($bomb=false, $hidden=true, $flagged=false) {
        $this->bomb = $bomb;
        $this->hidden = $hidden;
        $this->flagged = $flagged;
        $this->surroundingBombCount = 0;
    }

    public function isBomb() {
        return $this->bomb;
    }

    public function setBomb($bomb) {
        $this->bomb = $bomb;
    }

    public function isHidden() {
        return $this->hidden;
    }

    public function setHidden($hidden) {
        $this->hidden = $hidden;
    }

    public function isFlagged() {
        return $this->flagged;
    }

    public function setFlagged($flagged) {
        $this->flagged = $flagged;
    }

    public function toggleFlagged() {
        $this->setFlagged(!$this->flagged);
    }

    public function getSurroundingBombCount() {
        return $this->surroundingBombCount;
    }

    public function incrementSurroundingBombCount() {
        $this->surroundingBombCount++;
    }
}