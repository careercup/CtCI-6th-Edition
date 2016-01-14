<?php
require_once __DIR__ . DIRECTORY_SEPARATOR . 'Board.php';

class Game {
    const DEFAULT_INPUT_SOURCE = 'php://stdin';
    private $board;

    public function __construct(Board $board) {
        $this->board = $board;
    }

    private function getUsersNextMove($handle) {
        $length = $this->board->getLength();
        $width = $this->board->getWidth();
        $exampleRow = floor($length/2);
        $exampleColumn = floor($width/2);
        $examplePoint = $exampleRow . ',' . $exampleColumn;
        $prompt = 'Enter move in the format "[row],[column]" e.g. "' . $examplePoint . '". To toggle a flag on a cell, prefix with an "f" e.g. "f' . $examplePoint . '"';
        $move = null;
        do {
            echo $prompt . ': ';
            $input = rtrim(fgets($handle));
            try {
                $move = Move::parse($input, $length - 1, $width - 1);
            } catch (InvalidArgumentException $e) {
                echo "\nInvalid move. Please try again.\n";
            }
        } while ($move === null);
        return $move;
    }

    public function play($source=self::DEFAULT_INPUT_SOURCE) {
        $handle = @fopen($source, 'r');
        if ($handle === false) {
            throw new RuntimeException('Cannot read from ' . $source);
        }
        $error = null;
        do {
            echo "\n" . (!empty($error) ? $error : $this->board);
            $move = $this->getUsersNextMove($handle);
            try {
                $this->board->makeMove($move);
                $error = null;
            } catch (InvalidArgumentException $e) {
                $error = 'Invalid move: ' . $e->getMessage() . "\n";
            }
        } while ($this->board->getGameState() === Board::GAME_STATE_PLAYING);
        fclose($handle);
        $this->board->showAll();
        echo "\n" . $this->board;
        echo "Game Over\n";
        if ($this->board->getGameState() === Board::GAME_STATE_WON) {
            echo "You Won :)\n";
        } else {
            echo "You Lost :(\n";
        }
    }
}