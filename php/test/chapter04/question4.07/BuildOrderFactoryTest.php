<?php
require_once __DIR__ . '/../../../src/chapter04/question4.07/BuildOrderFactory.php';

class BuildOrderFactoryTest extends PHPUnit_Framework_TestCase {

    public function testGetBuildOrder() {
        $projects = [ "a", "b", "c", "d", "e", "f" ];
        $size = count($projects);
        $dependencies = [
            new Dependency("d", "a"),
            new Dependency("b", "f"),
            new Dependency("d", "b"),
            new Dependency("a", "f"),
            new Dependency("c", "d")
        ];
        $buildOrder = BuildOrderFactory::getBuildOrder($projects, $dependencies);
        $this->assertEquals($size, count($projects));
        $this->assertEquals($size, count($buildOrder));
        foreach ($dependencies as $d) {
            $dep = $d->getDependency();
            $proj = $d->getProject();
            $depIndex = array_search($dep, $buildOrder, true);
            $projIndex = array_search($proj, $buildOrder, true);
            $errorMessage = $dep . " (index " . $depIndex . ")"
                    . " comes after " . $proj . " (index " . $projIndex . ")"
                    . " which doesn't satisfy the dependency.";
            $this->assertTrue($depIndex < $projIndex, $errorMessage);
        }
    }

    public function testBuildOrderWithCircularReference() {
        $this->setExpectedException('InvalidArgumentException');
        $projects = [ "a", "b", "c", "d", "e", "f" ];
        $dependencies = [
            new Dependency("a", "b"),
            new Dependency("b", "c"),
            new Dependency("c", "d"),
            new Dependency("d", "e"),
            new Dependency("e", "f"),
            new Dependency("f", "a")
        ];
        BuildOrderFactory::getBuildOrder($projects, $dependencies);
    }

    public function testContainsAll() {
        $needles = [ "b", "d" ];
        $haystack = [ "a", "b", "c", "d", "e", "f" ];
        $this->assertTrue(BuildOrderFactory::containsAll($needles, $haystack));
    }

    public function testContainsAllWithEmptyNeedlesArray() {
        $needles = [];
        $haystack = [ "a", "b", "c", "d", "e", "f" ];
        $this->assertTrue(BuildOrderFactory::containsAll($needles, $haystack));
    }

    public function testDoesntContainAll() {
        $needles = [ "a", "b", "c", "x", "y", "z" ];
        $haystack = [ "a", "b", "c", "d", "e", "f" ];
        $this->assertFalse(BuildOrderFactory::containsAll($needles, $haystack));
    }
}
