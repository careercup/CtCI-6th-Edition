<?php
require_once __DIR__ . '/../../../src/chapter07/question7.10/Settings.php';

class SettingsTest extends PHPUnit_Framework_TestCase {

    public function testSettings() {
        $options = [
            'l' => '10',
            'w' => '20',
            'b' => '5'
        ];
        $settings = new Settings($options);
        $this->assertEquals(10, $settings->getLength());
        $this->assertEquals(20, $settings->getWidth());
        $this->assertEquals(5, $settings->getBombCount());
    }

    public function testSettingsWithLongOpts() {
        $options = [
            'length' => '8',
            'width' => '16',
            'bombs' => '4'
        ];
        $settings = new Settings($options);
        $this->assertEquals(8, $settings->getLength());
        $this->assertEquals(16, $settings->getWidth());
        $this->assertEquals(4, $settings->getBombCount());
    }

    public function testDefaultSettings() {
        $settings = new Settings();
        $this->assertEquals(Settings::DEFAULT_LENGTH, $settings->getLength());
        $this->assertEquals(Settings::DEFAULT_WIDTH, $settings->getWidth());
        $this->assertEquals(Settings::DEFAULT_BOMB_COUNT, $settings->getBombCount());
    }

    public function testInvalidLength() {
        $this->setExpectedException('InvalidArgumentException');
        $settings = new Settings([ 'length' => 100 ]);
    }

    public function testInvalidWidth() {
        $this->setExpectedException('InvalidArgumentException');
        $settings = new Settings([ 'width' => 100 ]);
    }

    public function testInvalidBombCount() {
        $this->setExpectedException('InvalidArgumentException');
        $settings = new Settings([ 'length' => 3, 'width' => 3, 'bombs' => 9 ]);
    }
}
