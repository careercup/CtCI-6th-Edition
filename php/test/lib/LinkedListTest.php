<?php
require_once __DIR__ . '/../../src/lib/LinkedList.php';

class LinkedListTest extends PHPUnit_Framework_TestCase {
    public function testLinkedList() {
        $list = new LinkedList();
        $this->assertEquals(0, $list->getSize());

        $this->assertNull($list->peekFirst());
        $this->assertNull($list->peekLast());
        $this->assertNull($list->removeFirst());
        $this->assertNull($list->removeLast());

        $count = 0;
        foreach ($list as $key => $value) {
            $count++;
        }
        $this->assertEquals(0, $count);

        $list->add("one");
        $this->assertEquals(1, $list->getSize());
        $list->add("two");
        $this->assertEquals(2, $list->getSize());
        $list->add("three");
        $this->assertEquals(3, $list->getSize());
        $expected = [ "one", "two", "three" ];
        $i=0;
        foreach ($list as $key => $value) {
            $this->assertEquals($i, $key);
            $this->assertEquals($expected[$i], $value);
            $i++;
        }
        $this->assertEquals(3, $i);

        $this->assertEquals("one", $list->peekFirst());
        $this->assertEquals("one", $list->removeFirst());
        $this->assertEquals(2, $list->getSize());
        $this->assertEquals("three", $list->peekLast());
        $this->assertEquals("three", $list->removeLast());
        $this->assertEquals(1, $list->getSize());
        $this->assertEquals("two", $list->peekFirst());
        $this->assertEquals("two", $list->removeFirst());
        $this->assertEquals(0, $list->getSize());

        $list->add("four");
        $this->assertEquals(1, $list->getSize());

        foreach ($list as $key => $value) {
            $this->assertEquals(0, $key);
            $this->assertEquals("four", $value);
        }

        $this->assertEquals("four", $list->peekFirst());
        $this->assertEquals("four", $list->removeLast());
        $this->assertEquals(0, $list->getSize());
    }
}