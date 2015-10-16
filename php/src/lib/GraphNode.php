<?php

class GraphNode {
    private $data;
    private $connectedNodes;

    public function __construct($data, array $connectedNodes = null) {
        $this->data = $data;
        $this->connectedNodes = $connectedNodes !== null ? $connectedNodes : [];
    }

    public function getData() {
        return $this->data;
    }

    public function setData($data) {
        $this->data = $data;
    }

    public function addNode(GraphNode $node) {
        return $this->connectedNodes[] = $node;
    }

    public function getConnectedNodes() {
        return $this->connectedNodes;
    }

    public function setConnectedNodes(array $connectedNodes) {
        $this->connectedNodes = $connectedNodes;
    }
}
