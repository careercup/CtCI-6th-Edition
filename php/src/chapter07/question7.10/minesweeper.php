<?php
require_once __DIR__ . DIRECTORY_SEPARATOR . 'Game.php';

$options = getopt(Settings::GETOPT_CONFIG, Settings::$longOptions);
try {
    (new Game(new Board(new Settings($options))))->play();
} catch (Exception $e) {
    echo $e->getMessage() . "\n";
}
