<?php
require_once __DIR__ . '/../../../src/chapter03/question3.1/ThreeStackArray.php';

class ThreeStackArrayTest extends PHPUnit_Framework_TestCase {

    public function testThreeStackArray() {
        $stack = new ThreeStackArray(30);
        $this->assertNull($stack->pop(0));
        $this->assertNull($stack->pop(1));
        $this->assertNull($stack->pop(2));
        $this->assertTrue($stack->isEmpty(0));
        $this->assertTrue($stack->isEmpty(1));
        $this->assertTrue($stack->isEmpty(2));
        $this->assertEquals(0, $stack->getSize(0));
        $this->assertEquals(0, $stack->getSize(1));
        $this->assertEquals(0, $stack->getSize(2));
        $this->assertEquals(10, $stack->getFreeSlotCount(0));
        $this->assertEquals(10, $stack->getFreeSlotCount(1));
        $this->assertEquals(10, $stack->getFreeSlotCount(2));

        $stack->push(1, 'apple');
        $this->assertFalse($stack->isEmpty(1));
        $this->assertEquals(1, $stack->getSize(1));
        $this->assertEquals(9, $stack->getFreeSlotCount(1));
        $stack->push(1, 'orange');
        $this->assertEquals(2, $stack->getSize(1));
        $this->assertEquals(8, $stack->getFreeSlotCount(1));
        $stack->push(1, 'banana');
        $this->assertEquals(3, $stack->getSize(1));
        $this->assertEquals(7, $stack->getFreeSlotCount(1));

        $this->assertEquals(3, $stack->getTotal());

        $stack->push(0, 'dog');
        $this->assertFalse($stack->isEmpty(0));
        $this->assertEquals(1, $stack->getSize(0));
        $this->assertEquals(9, $stack->getFreeSlotCount(0));
        $stack->push(0, 'cat');
        $this->assertEquals(2, $stack->getSize(0));
        $this->assertEquals(8, $stack->getFreeSlotCount(0));
        $stack->push(0, 'fish');
        $this->assertEquals(3, $stack->getSize(0));
        $this->assertEquals(7, $stack->getFreeSlotCount(0));

        $this->assertEquals(6, $stack->getTotal());

        // remove every value from stack 1
        $this->assertEquals('banana', $stack->pop(1));
        $this->assertEquals(2, $stack->getSize(1));
        $this->assertEquals(8, $stack->getFreeSlotCount(1));
        $this->assertEquals('orange', $stack->pop(1));
        $this->assertEquals(1, $stack->getSize(1));
        $this->assertEquals(9, $stack->getFreeSlotCount(1));
        $this->assertEquals('apple', $stack->pop(1));
        $this->assertTrue($stack->isEmpty(1));
        $this->assertEquals(0, $stack->getSize(1));
        $this->assertEquals(10, $stack->getFreeSlotCount(1));
        $this->assertNull($stack->pop(1));

        $this->assertEquals(3, $stack->getTotal());

        // add new values to stack 1
        $stack->push(1, 'grape');
        $this->assertFalse($stack->isEmpty(1));
        $this->assertEquals(1, $stack->getSize(1));
        $this->assertEquals(9, $stack->getFreeSlotCount(1));
        $stack->push(1, 'kiwi');
        $this->assertEquals(2, $stack->getSize(1));
        $this->assertEquals(8, $stack->getFreeSlotCount(1));
        $stack->push(1, 'lemon');
        $this->assertEquals(3, $stack->getSize(1));
        $this->assertEquals(7, $stack->getFreeSlotCount(1));

        $this->assertEquals(6, $stack->getTotal());

        $stack->push(2, 'onion');
        $this->assertEquals(9, $stack->getFreeSlotCount(2));
        $stack->push(2, 'carrot');
        $this->assertEquals(8, $stack->getFreeSlotCount(2));
        $stack->push(2, 'celery');
        $this->assertEquals(7, $stack->getFreeSlotCount(2));
        $stack->push(2, 'kale');
        $this->assertEquals(6, $stack->getFreeSlotCount(2));
        $stack->push(2, 'cabbage');
        $this->assertEquals(5, $stack->getFreeSlotCount(2));
        $stack->push(2, 'eggplant');
        $this->assertEquals(4, $stack->getFreeSlotCount(2));
        $stack->push(2, 'zucchini');
        $this->assertEquals(3, $stack->getFreeSlotCount(2));
        $stack->push(2, 'spinach');
        $this->assertEquals(2, $stack->getFreeSlotCount(2));
        $stack->push(2, 'broccoli');
        $this->assertEquals(1, $stack->getFreeSlotCount(2));
        $stack->push(2, 'cauliflower');
        $this->assertEquals(0, $stack->getFreeSlotCount(2));

        $this->assertEquals(16, $stack->getTotal());

        // this will run into the end of the array, forcing an adjustment
        $stack->push(2, 'corn');
        $this->assertEquals(11, $stack->getSize(2));
        $stack->push(2, 'beet');
        $this->assertEquals(12, $stack->getSize(2));
        $stack->push(2, 'lettuce');
        $this->assertEquals(13, $stack->getSize(2));
        $stack->push(2, 'radicchio');
        $this->assertEquals(14, $stack->getSize(2));
        $stack->push(2, 'okra');
        $this->assertEquals(15, $stack->getSize(2));
        $stack->push(2, 'turnip');
        $this->assertEquals(16, $stack->getSize(2));
        $stack->push(2, 'cucumber');
        $this->assertEquals(17, $stack->getSize(2));
        $stack->push(2, 'artichoke');
        $this->assertEquals(18, $stack->getSize(2));
        $stack->push(2, 'tomato');
        $this->assertEquals(19, $stack->getSize(2));

        $this->assertEquals(25, $stack->getTotal());

        $stack->push(0, 'pig');
        $this->assertEquals(4, $stack->getSize(0));
        $stack->push(0, 'lizard');
        $this->assertEquals(5, $stack->getSize(0));
        $stack->push(0, 'mouse');
        $this->assertEquals(6, $stack->getSize(0));
        $stack->push(0, 'monkey');
        $this->assertEquals(7, $stack->getSize(0));
        $stack->push(0, 'rabbit');
        $this->assertEquals(8, $stack->getSize(0));

        $this->assertEquals(30, $stack->getTotal());

        $this->assertEquals('rabbit', $stack->pop(0));
        $this->assertEquals('monkey', $stack->pop(0));
        $this->assertEquals('mouse', $stack->pop(0));
        $this->assertEquals('lizard', $stack->pop(0));
        $this->assertEquals('pig', $stack->pop(0));
        $this->assertEquals('fish', $stack->pop(0));
        $this->assertEquals('cat', $stack->pop(0));
        $this->assertEquals('dog', $stack->pop(0));
        $this->assertNull($stack->pop(0));

        $this->assertEquals(22, $stack->getTotal());

        $this->assertEquals('lemon', $stack->pop(1));
        $this->assertEquals('kiwi', $stack->pop(1));
        $this->assertEquals('grape', $stack->pop(1));
        $this->assertNull($stack->pop(1));

        $this->assertEquals(19, $stack->getTotal());

        $this->assertEquals('tomato', $stack->pop(2));
        $this->assertEquals('artichoke', $stack->pop(2));
        $this->assertEquals('cucumber', $stack->pop(2));
        $this->assertEquals('turnip', $stack->pop(2));
        $this->assertEquals('okra', $stack->pop(2));
        $this->assertEquals('radicchio', $stack->pop(2));
        $this->assertEquals('lettuce', $stack->pop(2));
        $this->assertEquals('beet', $stack->pop(2));
        $this->assertEquals('corn', $stack->pop(2));
        $this->assertEquals('cauliflower', $stack->pop(2));
        $this->assertEquals('broccoli', $stack->pop(2));
        $this->assertEquals('spinach', $stack->pop(2));
        $this->assertEquals('zucchini', $stack->pop(2));
        $this->assertEquals('eggplant', $stack->pop(2));
        $this->assertEquals('cabbage', $stack->pop(2));
        $this->assertEquals('kale', $stack->pop(2));
        $this->assertEquals('celery', $stack->pop(2));
        $this->assertEquals('carrot', $stack->pop(2));
        $this->assertEquals('onion', $stack->pop(2));
        $this->assertNull($stack->pop(2));

        $this->assertEquals(0, $stack->getTotal());
    }

    public function testOverflow() {
        $stack = new ThreeStackArray(3);
        $stack->push(0, 'a');
        $stack->push(1, 'b');
        $stack->push(2, 'c');
        $this->setExpectedException('RuntimeException');
        $stack->push(0, 'd');
    }
}
