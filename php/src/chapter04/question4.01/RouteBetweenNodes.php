<?php
require_once __DIR__ . '/../../lib/StatefulGraphNode.php';

class RouteBetweenNodes {
    public static function routeExists(StatefulGraphNode $startNode, StatefulGraphNode $endNode) {
        if ($startNode === $endNode) {
            return true;
        }
        $startNode->setState(StatefulGraphNode::VISITING);
        $queue = [ $startNode ];
        while (!empty($queue)) {
            $node = array_shift($queue);
            foreach ($node->getConnectedNodes() as $childNode) {
                if ($childNode->getState() === StatefulGraphNode::UNVISITED) {
                    if ($childNode === $endNode) {
                        return true;
                    }
                    $childNode->setState(StatefulGraphNode::VISITING);
                    array_push($queue, $childNode);
                }
            }
            $node->setState(StatefulGraphNode::VISITED);
        }
        return false;
    }
}
