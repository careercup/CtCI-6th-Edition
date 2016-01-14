<?php
require_once __DIR__ . '/../../../src/chapter07/question7.10/Game.php';

class MineSweeperTest extends PHPUnit_Framework_TestCase {

    public function testWinningGame() {
        $bombs = [ new Point(2,2), new Point(2,3), new Point(4,5) ];
        $settings = new Settings([ 'length' => 8, 'width' => 8, 'bombs' => count($bombs) ]);
        $board = new Board($settings);
        $board->initBombs($bombs);
        $game = new Game($board);
        ob_start();
        $game->play(__DIR__ . '/resources/winning_game_input.txt');
        $output = ob_get_clean();
        $expectedOutput = file_get_contents(__DIR__ . '/resources/winning_game_expected_output.txt');
        $this->assertEquals($expectedOutput, $output);
    }

    public function testLosingGame() {
        $bombs = [ new Point(2,2), new Point(2,3), new Point(4,5) ];
        $settings = new Settings([ 'length' => 8, 'width' => 8, 'bombs' => count($bombs) ]);
        $board = new Board($settings);
        $board->initBombs($bombs);
        $game = new Game($board);
        ob_start();
        $game->play(__DIR__ . '/resources/losing_game_input.txt');
        $output = ob_get_clean();
        $expectedOutput = file_get_contents(__DIR__ . '/resources/losing_game_expected_output.txt');
        $this->assertEquals($expectedOutput, $output);
    }

    public function testGameWithInvalidMove() {
        $bombs = [ new Point(2,2), new Point(2,3), new Point(4,5) ];
        $settings = new Settings([ 'length' => 8, 'width' => 8, 'bombs' => count($bombs) ]);
        $board = new Board($settings);
        $board->initBombs($bombs);
        $game = new Game($board);
        ob_start();
        $game->play(__DIR__ . '/resources/game_with_invalid_moves_input.txt');
        $output = ob_get_clean();
        $expectedOutput = file_get_contents(__DIR__ . '/resources/game_with_invalid_moves_expected_output.txt');
        $this->assertEquals($expectedOutput, $output);
    }

    public function testFlaggingGame() {
        $bombs = [ new Point(2,2), new Point(2,3), new Point(4,5) ];
        $settings = new Settings([ 'length' => 8, 'width' => 8, 'bombs' => count($bombs) ]);
        $board = new Board($settings);
        $board->initBombs($bombs);
        $game = new Game($board);
        ob_start();
        $game->play(__DIR__ . '/resources/flagging_game_input.txt');
        $output = ob_get_clean();
        $expectedOutput = file_get_contents(__DIR__ . '/resources/flagging_game_expected_output.txt');
        $this->assertEquals($expectedOutput, $output);
    }

    public function test5x6Game() {
        $bombs = [ new Point(2,2), new Point(2,3), new Point(4,5) ];
        $settings = new Settings([ 'length' => 5, 'width' => 6, 'bombs' => count($bombs) ]);
        $board = new Board($settings);
        $board->initBombs($bombs);
        $game = new Game($board);
        ob_start();
        $game->play(__DIR__ . '/resources/5x6_game_input.txt');
        $output = ob_get_clean();
        $expectedOutput = file_get_contents(__DIR__ . '/resources/5x6_game_expected_output.txt');
        $this->assertEquals($expectedOutput, $output);
    }

    public function testInvalidInputSource() {
        $game = new Game(new Board());
        $this->setExpectedException('RuntimeException');
        $game->play(__DIR__ . '/resources/file_not_found.txt');
    }
}
