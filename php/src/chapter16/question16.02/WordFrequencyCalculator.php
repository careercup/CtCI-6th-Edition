<?php

class WordFrequencyCalculator {
    private $wordFrequencyMap;

    public function __construct($filename) {
        $this->wordFrequencyMap = [];
        $handle = @fopen($filename, 'r');
        if ($handle === false) {
            throw new RuntimeException('Cannot open ' . $filename);
        }
        $word = '';
        while (($ch = fgetc($handle)) !== false) {
            if (ctype_alnum($ch) || $ch === "'") {
                $word .= $ch;
            } elseif (strlen($word) > 0) {
                $word = strtolower($word);
                if (array_key_exists($word, $this->wordFrequencyMap)) {
                    $this->wordFrequencyMap[$word]++;
                } else {
                    $this->wordFrequencyMap[$word] = 1;
                }
                $word = '';
            }
        }
        fclose($handle);
    }

    public function getFrequency($word) {
        $word = strtolower($word);
        return array_key_exists($word, $this->wordFrequencyMap) ? $this->wordFrequencyMap[$word] : 0;
    }
}