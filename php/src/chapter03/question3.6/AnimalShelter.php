<?php
require_once __DIR__ . '/../../lib/LinkedList.php';
require_once __DIR__ . DIRECTORY_SEPARATOR . 'Cat.php';
require_once __DIR__ . DIRECTORY_SEPARATOR . 'Dog.php';

class AnimalShelter {
    private $dogs;
    private $cats;
    private $index;

    public function __construct() {
        $this->dogs = new LinkedList();
        $this->cats = new LinkedList();
    }

    public function enqueue(Animal $animal) {
        $animal->setIndex($this->index++);
        if ($animal instanceof Dog) {
            $this->dogs->add($animal);
        } else if ($animal instanceof Cat) {
            $this->cats->add($animal);
        } else {
            throw new InvalidArgumentException('Unknown animal type: ' + get_class($animal));
        }
    }

    public function dequeueDog() {
        if ($this->dogs->isEmpty()) {
            return null;
        }
        return $this->dogs->removeFirst();
    }

    public function dequeueCat() {
        if ($this->cats->isEmpty()) {
            return null;
        }
        return $this->cats->removeFirst();
    }

    public function dequeueAny() {
        if ($this->dogs->isEmpty()) {
            if ($this->cats->isEmpty()) {
                return null;
            } else {
                return $this->dequeueCat();
            }
        } else if ($this->cats->isEmpty()) {
            return $this->dequeueDog();
        }
        $oldestDog = $this->dogs->peekFirst();
        $oldestCat = $this->cats->peekFirst();
        if ($oldestCat->getIndex() < $oldestDog->getIndex()) {
            return $this->dequeueCat();
        } else {
            return $this->dequeueDog();
        }
    }
}
