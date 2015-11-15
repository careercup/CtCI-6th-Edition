<?php
require_once __DIR__ . DIRECTORY_SEPARATOR . 'Settings.php';
require_once __DIR__ . DIRECTORY_SEPARATOR . 'Cell.php';
require_once __DIR__ . DIRECTORY_SEPARATOR . 'Move.php';
require_once __DIR__ . DIRECTORY_SEPARATOR . 'RandomPointGenerator.php';

class Board {
    const GAME_STATE_PLAYING = 0;
    const GAME_STATE_LOST = 1;
    const GAME_STATE_WON = 2;
    private $settings;
    private $hiddenCount;
    private $cells;
    private $gameState;
    private $bombsInitialized;

    public function __construct(Settings $settings=null) {
        $this->settings = $settings !== null ? $settings : new Settings();
        $this->hiddenCount = $this->getLength() * $this->getWidth();
        $this->cells = [];
        for ($i=0; $i<$this->getLength(); $i++) {
            $this->cells[$i] = [];
            for ($j=0; $j<$this->getWidth(); $j++) {
                $this->cells[$i][$j] = new Cell();
            }
        }
        $this->bombsInitialized = false;
        $this->gameState = self::GAME_STATE_PLAYING;
    }

    public function initBombs(array $points) {
        if (count($points) != $this->getBombCount()) {
            throw new InvalidArgumentException('Expected ' . $this->getBombCount() . ' bomb points but found ' . count($points));
        }
        foreach ($points as $p) {
            $row = $p->getRow();
            $column = $p->getColumn();
            $cell = $this->cells[$row][$column];
            if ($cell->isBomb()) {
                throw new InvalidArgumentException('Duplicate bomb point: ' . $p);
            }
            $cell->setBomb(true);
            $this->incrementSurroundingBombCountOfSurroundingCells($row, $column);
        }
        $this->bombsInitialized = true;
    }

    private function incrementSurroundingBombCountOfSurroundingCells($row, $column) {
        for ($i=max($row-1, 0); $i<=min($row+1, $this->getLength()-1); $i++) {
            for ($j=max($column-1, 0); $j<=min($column+1, $this->getWidth()-1); $j++) {
                if ($i == $row && $j == $column) {
                    continue;
                }
                $this->cells[$i][$j]->incrementSurroundingBombCount();
            }
        }
    }

    public function getLength() {
        return $this->settings->getLength();
    }

    public function getWidth() {
        return $this->settings->getWidth();
    }

    public function getBombCount() {
        return $this->settings->getBombCount();
    }

    public function getCell($row, $column) {
        return $this->cells[$row][$column];
    }

    public function getGameState() {
        return $this->gameState;
    }

    private function isGameWon() {
        return $this->hiddenCount == $this->getBombCount();
    }

    public function makeMove(Move $move) {
        if ($this->gameState !== self::GAME_STATE_PLAYING) {
            throw new InvalidArgumentException('game is already over');
        }
        $row = $move->getRow();
        $column = $move->getColumn();
        // wait until the user makes a first move to initialize the bomb locations
        // in order to ensure that the first move doesn't ever land on a mine
        if (!$this->bombsInitialized) {
            $points = RandomPointGenerator::generate($this->getLength(), $this->getWidth(), $row, $column, $this->getBombCount());
            $this->initBombs($points);
        }
        $cell = $this->getCell($row, $column);
        if (!$cell->isHidden()) {
            throw new InvalidArgumentException($row . ',' . $column . ' is already showing');
        }
        if ($move->isFlag()) {
            $cell->toggleFlagged();
            return;
        }
        if ($cell->isBomb()) {
            $this->gameState = self::GAME_STATE_LOST;
        } else {
            $cell->setHidden(false);
            $this->hiddenCount--;
            if ($cell->getSurroundingBombCount() === 0) {
                $this->revealSurroundingCells($row, $column);
            }
            if ($this->isGameWon()) {
                $this->gameState = self::GAME_STATE_WON;
            }
        }
    }

    private function revealSurroundingCells($row, $column) {
        $queue = [ new Point($row, $column) ];
        while (!empty($queue)) {
            $point = array_shift($queue);
            $row = $point->getRow();
            $column = $point->getColumn();
            for ($i=max($row-1, 0); $i<=min($row+1, $this->getLength()-1); $i++) {
                for ($j=max($column-1, 0); $j<=min($column+1, $this->getWidth()-1); $j++) {
                    if ($i == $row && $j == $column) {
                        continue;
                    }
                    $cell = $this->getCell($i, $j);
                    if (!$cell->isHidden() || $cell->isBomb() || $cell->isFlagged()) {
                        continue;
                    }
                    $cell->setHidden(false);
                    $this->hiddenCount--;
                    if ($cell->getSurroundingBombCount() === 0) {
                        array_push($queue, new Point($i, $j));
                    }
                }
            }
        }
    }

    public function showAll() {
        for ($i=0; $i<$this->getLength(); $i++) {
            for ($j=0; $j<$this->getWidth(); $j++) {
                $this->getCell($i, $j)->setHidden(false);
            }
        }
        $this->hiddenCount = 0;
    }

    public function __toString() {
        $board = '    ';
        for ($i=0; $i<$this->getWidth(); $i++) {
            $board .= str_pad($i, 2, ' ', STR_PAD_LEFT) . ' ';
        }
        $board .= "\n   ";
        for ($i=0; $i<$this->getWidth(); $i++) {
            $board .= '---';
        }
        $board .= "--\n";
        for ($i=0; $i<$this->getLength(); $i++) {
            $board .= str_pad($i, 2, ' ', STR_PAD_LEFT) . ' |';
            for ($j=0; $j<$this->getWidth(); $j++) {
                $cell = $this->getCell($i, $j);
                if ($cell->isHidden()) {
                    $board .= $cell->isFlagged() ? ' f ' : ' ? ';
                } else {
                    if ($cell->isBomb()) {
                        $board .= ' * ';
                    } else {
                        $surroundingBombCount = $cell->getSurroundingBombCount();
                        if ($surroundingBombCount > 0) {
                            $board .= str_pad($surroundingBombCount, 2, ' ', STR_PAD_LEFT) . ' ';
                        } else {
                            $board .= '   ';
                        }
                    }
                }
            }
            $board .= "|\n";
        }
        $board .= '   ';
        for ($i=0; $i<$this->getWidth(); $i++) {
            $board .= '---';
        }
        $board .= "--\n";
        return $board;
    }
}