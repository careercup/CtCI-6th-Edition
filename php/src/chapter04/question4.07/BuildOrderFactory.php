<?php
require_once __DIR__ . DIRECTORY_SEPARATOR . 'Dependency.php';

class BuildOrderFactory {
    public static function getBuildOrder(array &$projects, array &$dependencyPairs) {
        // build a data structure that lists each project's dependencies for quick lookup later
        $dependencyLists = [];
        foreach ($dependencyPairs as $dependencyPair) {
            $project = $dependencyPair->getProject();
            $dependency = $dependencyPair->getDependency();
            if (array_key_exists($project, $dependencyLists)) {
                $dependencyLists[$project][] = $dependency;
            } else {
                $dependencyLists[$project] = [ $dependency ];
            }
        }
        // using the above data structure, add all the projects such that dependencies are satisfied
        $buildOrder = [];
        $visitedProjects = [];
        self::addProjectsInOrder($projects, $buildOrder, $visitedProjects, $dependencyLists);
        return $buildOrder;
    }

    private static function addProjectsInOrder(array &$projects, array &$buildOrder, array &$visitedProjects, array &$dependencyLists) {
        foreach ($projects as $project) {
            if (in_array($project, $buildOrder, true)) {
                continue;
            }
            if (array_key_exists($project, $visitedProjects)) {
                throw new InvalidArgumentException("Circular reference detected in dependencies list!");
            }
            $visitedProjects[$project] = 1;
            $dependencies = array_key_exists($project, $dependencyLists) ? $dependencyLists[$project] : [];
            self::addProjectsInOrder($dependencies, $buildOrder, $visitedProjects, $dependencyLists);
            $buildOrder[] = $project;
            unset($visitedProjects[$project]);
        }
    }
}
