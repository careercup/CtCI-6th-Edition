<?php
require_once __DIR__ . '/../../../src/chapter03/question3.6/AnimalShelter.php';

class AnimalShelterTest extends PHPUnit_Framework_TestCase {

    public function testAnimalShelter() {
        $shelter = new AnimalShelter();
        $benji = new Dog("Benji");
        $rover = new Dog("Rover");
        $harry = new Dog("Harry");
        $felix = new Dog("Felix");

        $thelma = new Cat("Thelma");
        $alice = new Cat("Alice");
        $olga = new Cat("Olga");
        $agatha = new Cat("Agatha");

        $shelter->enqueue($thelma);
        $shelter->enqueue($alice);
        $shelter->enqueue($rover);
        $shelter->enqueue($olga);
        $shelter->enqueue($felix);
        $shelter->enqueue($benji);
        $shelter->enqueue($harry);
        $shelter->enqueue($agatha);

        $this->assertSame($thelma, $shelter->dequeueAny());
        $this->assertSame($rover, $shelter->dequeueDog());
        $this->assertSame($alice, $shelter->dequeueCat());
        $this->assertSame($felix, $shelter->dequeueDog());
        $this->assertSame($olga, $shelter->dequeueAny());
        $this->assertSame($benji, $shelter->dequeueAny());
        $this->assertSame($harry, $shelter->dequeueAny());
        $this->assertSame($agatha, $shelter->dequeueAny());
        $this->assertNull($shelter->dequeueDog());
        $this->assertNull($shelter->dequeueCat());
        $this->assertNull($shelter->dequeueAny());

        $shelter->enqueue($harry);
        $this->assertSame($harry, $shelter->dequeueAny());
        $this->assertNull($shelter->dequeueAny());
    }
}
