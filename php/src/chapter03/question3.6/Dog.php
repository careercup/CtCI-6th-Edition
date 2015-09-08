<?php
require_once __DIR__ . DIRECTORY_SEPARATOR . 'Animal.php';

class Dog extends Animal {

    public function __construct($name) {
        parent::__construct($name);
    }
}
