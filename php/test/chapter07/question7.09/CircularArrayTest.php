<?php
require_once __DIR__ . '/../../../src/chapter07/question7.09/CircularArray.php';

class CircularArrayTest extends PHPUnit_Framework_TestCase {

    public function testCircularArrayRotation() {
        $arr = new CircularArray();
        $this->assertEquals(0, count($arr));
        $arr[] = 'zero';
        $this->assertEquals(1, count($arr));
        $arr[] = 'one';
        $this->assertEquals(2, count($arr));
        $arr[] = 'two';
        $this->assertEquals(3, count($arr));

        $this->assertEquals('zero', $arr[0]);
        $this->assertEquals('one', $arr[1]);
        $this->assertEquals('two', $arr[2]);

        $expected = [ 0 => 'zero', 1 => 'one', 2 => 'two' ];
        $i=0;
        foreach ($arr as $key => $value) {
            $this->assertEquals($i, $key);
            $this->assertEquals($expected[$i], $value);
            $i++;
        }

        $arr->rotate(1);
        $this->assertEquals(3, count($arr));

        $expected = [ 0 => 'two', 1 => 'zero', 2 => 'one' ];
        $i=0;
        foreach ($arr as $key => $value) {
            $this->assertEquals($i, $key);
            $this->assertEquals($expected[$i], $value);
            $i++;
        }
        $this->assertEquals('two', $arr[0]);
        $this->assertEquals('zero', $arr[1]);
        $this->assertEquals('one', $arr[2]);
    }

    public function testCircularArrayCount() {
        $arr = new CircularArray();
        $arr[0] = 'a';
        $arr[1] = 'b';
        $this->assertEquals(2, count($arr));
        $this->assertEquals('a', $arr[0]);
        $this->assertEquals('b', $arr[1]);
        $arr[1] = 'c';
        $this->assertEquals(2, count($arr));
        $this->assertEquals('a', $arr[0]);
        $this->assertEquals('c', $arr[1]);
        unset($arr[1]);
        $this->assertEquals(1, count($arr));
        $this->assertEquals('a', $arr[0]);
    }

    public function testCircularArrayRotationBackwardsAndForwards() {
        $arr = new CircularArray('a', 'b', 'c', 'd', 'e');
        $this->assertEquals('a', $arr[0]);
        $this->assertEquals('b', $arr[1]);
        $this->assertEquals('c', $arr[2]);
        $this->assertEquals('d', $arr[3]);
        $this->assertEquals('e', $arr[4]);
        $arr->rotate(3);
        $this->assertEquals('c', $arr[0]);
        $this->assertEquals('d', $arr[1]);
        $this->assertEquals('e', $arr[2]);
        $this->assertEquals('a', $arr[3]);
        $this->assertEquals('b', $arr[4]);
        $arr->rotate(7);
        $this->assertEquals('a', $arr[0]);
        $this->assertEquals('b', $arr[1]);
        $this->assertEquals('c', $arr[2]);
        $this->assertEquals('d', $arr[3]);
        $this->assertEquals('e', $arr[4]);
        $arr->rotate(-5);
        $this->assertEquals('a', $arr[0]);
        $this->assertEquals('b', $arr[1]);
        $this->assertEquals('c', $arr[2]);
        $this->assertEquals('d', $arr[3]);
        $this->assertEquals('e', $arr[4]);
        $arr->rotate(-25);
        $this->assertEquals('a', $arr[0]);
        $this->assertEquals('b', $arr[1]);
        $this->assertEquals('c', $arr[2]);
        $this->assertEquals('d', $arr[3]);
        $this->assertEquals('e', $arr[4]);
        $arr->rotate(-3);
        $this->assertEquals('d', $arr[0]);
        $this->assertEquals('e', $arr[1]);
        $this->assertEquals('a', $arr[2]);
        $this->assertEquals('b', $arr[3]);
        $this->assertEquals('c', $arr[4]);
        $arr->rotate(18);
        $this->assertEquals('a', $arr[0]);
        $this->assertEquals('b', $arr[1]);
        $this->assertEquals('c', $arr[2]);
        $this->assertEquals('d', $arr[3]);
        $this->assertEquals('e', $arr[4]);
    }

    public function testCircularArrayZeroLengthRotation() {
        $arr = new CircularArray();
        $this->assertEquals(0, count($arr));
        $arr->rotate(6);
        $this->assertEquals(0, count($arr));
        $arr->rotate(0);
        $this->assertEquals(0, count($arr));
    }

    public function testAddInvalidOffset() {
        $arr = new CircularArray();
        $this->setExpectedException('OutOfRangeException');
        $arr['invalid'] = 'value';
    }

    public function testAddOutOfRangeOffset() {
        $arr = new CircularArray();
        $arr[0] = 'zero';
        $arr[1] = 'one';
        $this->setExpectedException('OutOfRangeException');
        $arr[3] = 'three';
    }

    public function testAddToArrayAfterRotation() {
        $arr = new CircularArray('zero', 'one', 'two');
        $this->assertEquals('zero', $arr[0]);
        $this->assertEquals('one', $arr[1]);
        $this->assertEquals('two', $arr[2]);
        $arr[3] = 'three';
        $this->assertEquals('three', $arr[3]);
        $arr->rotate(2);
        $this->assertEquals('two', $arr[0]);
        $this->assertEquals('three', $arr[1]);
        $this->assertEquals('zero', $arr[2]);
        $this->assertEquals('one', $arr[3]);
        $this->setExpectedException('OutOfRangeException');
        $arr[4] = 'four';
    }

    public function testUnsetAfterRotation() {
        $arr = new CircularArray('zero', 'one', 'two');
        $this->assertEquals('zero', $arr[0]);
        $this->assertEquals('one', $arr[1]);
        $this->assertEquals('two', $arr[2]);
        $arr->rotate(1);
        $this->assertEquals('two', $arr[0]);
        $this->assertEquals('zero', $arr[1]);
        $this->assertEquals('one', $arr[2]);
        $this->setExpectedException('OutOfRangeException');
        unset($arr[2]);
    }

    public function testUnsetLastElement() {
        $arr = new CircularArray('zero', 'one', 'two');
        $this->assertEquals(3, count($arr));
        unset($arr[2]);
        $this->assertEquals(2, count($arr));
    }

    public function testUnsetMiddleElement() {
        $arr = new CircularArray('zero', 'one', 'two');
        $this->assertEquals(3, count($arr));
        $this->setExpectedException('OutOfRangeException');
        unset($arr[1]);
    }

    public function testUnsetWithInvalidOffset() {
        $arr = new CircularArray('zero', 'one', 'two');
        $this->assertEquals(3, count($arr));
        $this->setExpectedException('OutOfRangeException');
        unset($arr[99]);
    }
}
