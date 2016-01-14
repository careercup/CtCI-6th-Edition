<?php

class QueenArrangementsCalculator {
    const WIDTH = 8;
    const UNDETERMINED = '?';
    const QUEEN = 'Q';

    public static function getQueenArrangements($row=0, array &$chessBoard=null) {
        if ($chessBoard === null) {
            $chessBoard = [];
            for ($i=0; $i<self::WIDTH; $i++) {
                $chessBoard[$i] = [];
                for ($j=0; $j<self::WIDTH; $j++) {
                    $chessBoard[$i][$j] = self::UNDETERMINED;
                }
            }
        }
        $arrangements = [];
        foreach ($chessBoard[$row] as $col => $state) {
            $clonedChessBoard = $chessBoard; // make a copy
            $clonedChessBoard[$row][$col] = self::QUEEN;
            // blank out all spaces in a vertical line below
            for ($i=$row+1; $i<self::WIDTH; $i++) {
                unset($clonedChessBoard[$i][$col]);
            }
            // blank out all spaces diagonal down and left
            for ($i=$row+1, $j=$col-1; $i<self::WIDTH && $j>=0; $i++, $j--) {
                unset($clonedChessBoard[$i][$j]);
            }
            // blank out all spaces diagonal down and right
            for ($i=$row+1, $j=$col+1; $i<self::WIDTH && $j<self::WIDTH; $i++, $j++) {
                unset($clonedChessBoard[$i][$j]);
            }
            if ($row+1 < self::WIDTH) {
                $arrangements = array_merge($arrangements, self::getQueenArrangements($row+1, $clonedChessBoard));
            } else {
                $arrangements[] = $clonedChessBoard;
            }
        }
        return $arrangements;
    }

    public static function chessBoardToString(array &$chessBoard) {
        $str = str_repeat('_', self::WIDTH * 2 + 1) . "\n";
        for ($row=0; $row<self::WIDTH; $row++) {
            $str .= '|';
            for ($col=0; $col<self::WIDTH; $col++) {
                $char = isset($chessBoard[$row][$col]) ? $chessBoard[$row][$col] : null;
                if ($char !== self::QUEEN) {
                    $char = '_';
                }
                $str .= $char . '|';
            }
            $str .= "\n";
        }
        return $str;
    }

    public static function printAllWaysToArrangeEightQueens() {
        $arrangements = self::getQueenArrangements();
        $i=0;
        foreach ($arrangements as $chessBoard) {
            echo "Queen Arrangement #" . ++$i . "\n";
            echo self::chessBoardToString($chessBoard) . "\n";
        }
    }
}