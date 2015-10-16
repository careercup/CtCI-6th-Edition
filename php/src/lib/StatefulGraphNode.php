<?php
require_once __DIR__ . DIRECTORY_SEPARATOR . 'GraphNode.php';

class StatefulGraphNode extends GraphNode {
    const UNVISITED = 0;
    const VISITING = 1;
    const VISITED = 2;
    private $state;

    public function __construct($data, array $connectedNodes = null) {
        parent::__construct($data, $connectedNodes);
        $this->reset();
    }

    public function getState() {
        return $this->state;
    }

    public function setState($state) {
        $this->state = $state;
    }

    public function reset() {
        $this->state = self::UNVISITED;
    }
}