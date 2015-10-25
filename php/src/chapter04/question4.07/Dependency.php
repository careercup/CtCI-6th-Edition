<?php

class Dependency {
    private $project;
    private $dependency;

    public function __construct($project, $dependency) {
        $this->project = $project;
        $this->dependency = $dependency;
    }

    public function getProject() {
        return $this->project;
    }

    public function setProject($project) {
        $this->project = $project;
    }

    public function getDependency() {
        return $this->dependency;
    }

    public function setDependency($dependency) {
        $this->dependency = $dependency;
    }
}
