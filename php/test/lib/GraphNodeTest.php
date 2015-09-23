<?php
require_once __DIR__ . '/../../src/lib/GraphNode.php';

class GraphNodeTest extends PHPUnit_Framework_TestCase {

    public function testGraphNode() {
        $node1 = new GraphNode('Miles');
        $this->assertEquals('Miles', $node1->getData());
        $node1->setData('Coltrane');
        $this->assertEquals('Coltrane', $node1->getData());

        $connectedNodes = $node1->getConnectedNodes();
        $this->assertTrue(is_array($connectedNodes));
        $this->assertTrue(empty($connectedNodes));

        $node2 = new GraphNode('Mingus');
        $node3 = new GraphNode('Monk');

        $node1->addNode($node2);
        $node1->addNode($node3);

        $connectedNodes = $node1->getConnectedNodes();
        $this->assertTrue(is_array($connectedNodes));
        $this->assertEquals(array($node2, $node3), $connectedNodes);
    }
}