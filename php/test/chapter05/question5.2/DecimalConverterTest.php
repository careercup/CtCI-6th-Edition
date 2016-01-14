<?php
require_once __DIR__ . '/../../../src/chapter05/question5.2/DecimalConverter.php';

class DecimalConverterTest extends PHPUnit_Framework_TestCase {

    public function getTestCases() {
        return [
            [0.125, '.001'],
            [0.25, '.01'],
            [0.375, '.011'],
            [0.5, '.1'],
            [0.625, '.101'],
            [0.75, '.11'],
            [0.875, '.111']
        ];
    }

    public function getErrorCases() {
        $testNumbers = [];
        foreach ($this->getTestCases() as $testCase) {
            $testNumbers[] = $testCase[0];
        }
        $errorCases = [ [ 1.1 ], [ -0.5 ] ];
        for ($i=1; $i<1000; $i++) {
            $n = $i/1000;
            if (in_array($n, $testNumbers)) {
                continue;
            }
            $errorCases[] = [ $n ];
        }
        return $errorCases;
    }

    /**
     * @dataProvider getTestCases
     */
    public function testToBinary($n, $expected) {
        $this->assertEquals($expected, DecimalConverter::toBinary($n));
    }

    /**
     * @dataProvider getErrorCases
     */
    public function testErrorCases($n) {
        $this->assertEquals('ERROR', DecimalConverter::toBinary($n));
    }
}
