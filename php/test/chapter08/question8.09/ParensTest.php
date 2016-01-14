<?php
require_once __DIR__ . '/../../../src/chapter08/question8.09/Parens.php';

class ParensTest extends PHPUnit_Framework_TestCase {

    public function testGetParenCombinationsWithOnePairOfParens() {
        $combinations = Parens::getParenCombinations(1);
        $expected = [ '()' ];
        $this->assertEquals($expected, $combinations);
    }

    public function testGetParenCombinationsWithTwoPairsOfParens() {
        $combinations = Parens::getParenCombinations(2);
        $expected = [ '(())', '()()' ];
        $this->assertEquals($expected, $combinations);
    }

    public function testGetParenCombinationsWithThreePairsOfParens() {
        $combinations = Parens::getParenCombinations(3);
        $expected = [ '((()))', '(()())', '(())()', '()(())', '()()()' ];
        $this->assertEquals($expected, $combinations);
    }

    public function testGetParenCombinationsWithFourPairsOfParens() {
        $combinations = Parens::getParenCombinations(4);
        $expected = [
            '(((())))',
            '((()()))',
            '((())())',
            '((()))()',
            '(()(()))',
            '(()()())',
            '(()())()',
            '(())(())',
            '(())()()',
            '()((()))',
            '()(()())',
            '()(())()',
            '()()(())',
            '()()()()'
        ];
        $this->assertEquals($expected, $combinations);
    }
}
