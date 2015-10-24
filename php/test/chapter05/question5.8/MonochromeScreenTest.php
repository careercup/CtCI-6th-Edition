<?php
require_once __DIR__ . '/../../../src/chapter05/question5.8/MonochromeScreen.php';

class MonochromeScreenTest extends PHPUnit_Framework_TestCase {

    public function testDrawLineOn16x16Screen() {
        // 16x16 screen
        $screen = [
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,

            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,

            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,

            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
        ];
        $width = 16;
        // draw a line that spans 2 bytes
        MonochromeScreen::drawLine($screen, $width, 3, 12, 3);
        $expected = [
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
            0b00011111, 0b11111000,

            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,

            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,

            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
            0b00000000, 0b00000000,
        ];
        $this->assertEquals($expected, $screen);
    }

    public function testDrawLineOn32x8Screen() {
        // 32x8 screen
        $screen = [
            0b00000000, 0b00000000, 0b00000000, 0b00000000,
            0b00000000, 0b00000000, 0b00000000, 0b00000000,
            0b00000000, 0b00000000, 0b00000000, 0b00000000,
            0b00000000, 0b00000000, 0b00000000, 0b00000000,

            0b00000000, 0b00000000, 0b00000000, 0b00000000,
            0b00000000, 0b00000000, 0b00000000, 0b00000000,
            0b00000000, 0b00000000, 0b00000000, 0b00000000,
            0b00000000, 0b00000000, 0b00000000, 0b00000000
        ];
        $width = 32;
        // draw a line that starts and ends in the same byte
        MonochromeScreen::drawLine($screen, $width, 17, 19, 1);
        // draw a line that takes up a whole row
        MonochromeScreen::drawLine($screen, $width, 0, 31, 2);
        // draw a line that spans 3 bytes
        MonochromeScreen::drawLine($screen, $width, 13, 27, 5);
        // draw a backwards line
        MonochromeScreen::drawLine($screen, $width, 27, 13, 6);
        // draw a single pixel
        MonochromeScreen::drawLine($screen, $width, 9, 9, 7);
        $expected = [
            0b00000000, 0b00000000, 0b00000000, 0b00000000,
            0b00000000, 0b00000000, 0b01110000, 0b00000000,
            0b11111111, 0b11111111, 0b11111111, 0b11111111,
            0b00000000, 0b00000000, 0b00000000, 0b00000000,

            0b00000000, 0b00000000, 0b00000000, 0b00000000,
            0b00000000, 0b00000111, 0b11111111, 0b11110000,
            0b00000000, 0b00000111, 0b11111111, 0b11110000,
            0b00000000, 0b01000000, 0b00000000, 0b00000000
        ];
        $this->assertEquals($expected, $screen);
    }
}
