<?php

class Settings {
    const DEFAULT_LENGTH = 8;
    const DEFAULT_WIDTH = 8;
    const DEFAULT_BOMB_COUNT = 8;
    const MAX_DIMENSION = 99;
    const GETOPT_CONFIG = 'l:w:b:';
    public static $longOptions = [ 'length:', 'width:', 'bombs:' ];
    private $length;
    private $width;
    private $bombCount;

    public function __construct(array $options=[]) {
        $this->length = self::DEFAULT_LENGTH;
        if (isset($options['length'])) {
            $this->length = $options['length'];
        } elseif (isset($options['l'])) {
            $this->length = $options['l'];
        }
        if (!self::isValidDimension($this->length)) {
            throw new InvalidArgumentException('Invalid length: ' . $this->length);
        }

        $this->width = self::DEFAULT_WIDTH;
        if (isset($options['width'])) {
            $this->width = $options['width'];
        } elseif (isset($options['w'])) {
            $this->width = $options['w'];
        }
        if (!self::isValidDimension($this->width)) {
            throw new InvalidArgumentException('Invalid width: ' . $this->width);
        }

        $this->bombCount = self::DEFAULT_BOMB_COUNT;
        if (isset($options['bombs'])) {
            $this->bombCount = $options['bombs'];
        } elseif (isset($options['b'])) {
            $this->bombCount = $options['b'];
        }
        if (!self::isValidBombCount($this->bombCount)) {
            throw new InvalidArgumentException('Invalid bomb count: ' . $this->bombCount);
        }
    }

    public function getLength() {
        return $this->length;
    }

    public function getWidth() {
        return $this->width;
    }

    public function getBombCount() {
        return $this->bombCount;
    }

    protected static function isPositiveInteger($input) {
        return preg_match('/^\d+$/', $input);
    }

    protected static function isValidDimension($input) {
        return self::isPositiveInteger($input) && $input > 0 && $input <= self::MAX_DIMENSION;
    }

    protected function isValidBombCount($input) {
        return self::isPositiveInteger($input) && $input > 0 && $input < $this->length * $this->width;
    }
}