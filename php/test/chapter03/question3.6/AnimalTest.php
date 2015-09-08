<?php
require_once __DIR__ . '/../../../src/chapter03/question3.6/Cat.php';
require_once __DIR__ . '/../../../src/chapter03/question3.6/Dog.php';

class AnimalTest extends PHPUnit_Framework_TestCase {

    public function testCat() {
        $cat = new Cat("Thelma");
        $this->assertEquals("Thelma", $cat->getName());
        $this->assertEquals("Thelma the Cat", (string) $cat);
        $cat->setName("Alice");
        $this->assertEquals("Alice", $cat->getName());
        $this->assertEquals("Alice the Cat", (string) $cat);
    }

    public function testDog() {
        $dog = new Dog("Benji");
        $this->assertEquals("Benji", $dog->getName());
        $this->assertEquals("Benji the Dog", (string) $dog);
        $dog->setName("Rover");
        $this->assertEquals("Rover", $dog->getName());
        $this->assertEquals("Rover the Dog", (string) $dog);
    }
}
