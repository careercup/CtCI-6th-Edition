<?php
require_once __DIR__ . '/../../../src/chapter04/question4.01/RouteBetweenNodes.php';

class RouteBetweenNodesTest extends PHPUnit_Framework_TestCase {

    public function testRouteExists() {
        $n1 = new StatefulGraphNode("one");
        $n2 = new StatefulGraphNode("two");
        $n3 = new StatefulGraphNode("three");
        $n4 = new StatefulGraphNode("four");
        $n5 = new StatefulGraphNode("five");
        $n6 = new StatefulGraphNode("six");
        $n7 = new StatefulGraphNode("seven");
        $n8 = new StatefulGraphNode("eight");
        $n9 = new StatefulGraphNode("nine");
        $n10 = new StatefulGraphNode("ten");
        $n11 = new StatefulGraphNode("eleven");
        $n12 = new StatefulGraphNode("twelve");

        $graph = [ $n1, $n2, $n3, $n4, $n5, $n6, $n7, $n8, $n9, $n10, $n11, $n12 ];

        // Graph A
        $n1->addNode($n2);
        $n1->addNode($n3);
        $n1->addNode($n4);

        $n3->addNode($n5);
        $n3->addNode($n6);

        // Graph B
        $n7->addNode($n8);
        $n7->addNode($n9);
        $n7->addNode($n12);

        $n8->addNode($n10);

        $n9->addNode($n11);
        $n9->addNode($n12); // There are now 2 nodes connected to $n12

        $this->assertTrue(RouteBetweenNodes::routeExists($n1, $n1));
        self::resetNodes($graph);
        $this->assertTrue(RouteBetweenNodes::routeExists($n1, $n2));
        self::resetNodes($graph);
        $this->assertTrue(RouteBetweenNodes::routeExists($n1, $n3));
        self::resetNodes($graph);
        $this->assertTrue(RouteBetweenNodes::routeExists($n1, $n4));
        self::resetNodes($graph);
        $this->assertTrue(RouteBetweenNodes::routeExists($n1, $n5));
        self::resetNodes($graph);
        $this->assertTrue(RouteBetweenNodes::routeExists($n1, $n6));

        self::resetNodes($graph);
        $this->assertFalse(RouteBetweenNodes::routeExists($n1, $n7));
        self::resetNodes($graph);
        $this->assertFalse(RouteBetweenNodes::routeExists($n1, $n8));
        self::resetNodes($graph);
        $this->assertFalse(RouteBetweenNodes::routeExists($n1, $n9));
        self::resetNodes($graph);
        $this->assertFalse(RouteBetweenNodes::routeExists($n1, $n10));
        self::resetNodes($graph);
        $this->assertFalse(RouteBetweenNodes::routeExists($n1, $n11));
        self::resetNodes($graph);
        $this->assertFalse(RouteBetweenNodes::routeExists($n1, $n12));

        // connect Graph A and Graph B
        $n6->addNode($n7);

        self::resetNodes($graph);
        $this->assertTrue(RouteBetweenNodes::routeExists($n1, $n7));
        self::resetNodes($graph);
        $this->assertTrue(RouteBetweenNodes::routeExists($n1, $n8));
        self::resetNodes($graph);
        $this->assertTrue(RouteBetweenNodes::routeExists($n1, $n9));
        self::resetNodes($graph);
        $this->assertTrue(RouteBetweenNodes::routeExists($n1, $n10));
        self::resetNodes($graph);
        $this->assertTrue(RouteBetweenNodes::routeExists($n1, $n11));
        self::resetNodes($graph);
        $this->assertTrue(RouteBetweenNodes::routeExists($n1, $n12));

        // disconnect them again
        $n6->setConnectedNodes([]);

        self::resetNodes($graph);
        $this->assertFalse(RouteBetweenNodes::routeExists($n1, $n7));
        self::resetNodes($graph);
        $this->assertFalse(RouteBetweenNodes::routeExists($n1, $n8));
        self::resetNodes($graph);
        $this->assertFalse(RouteBetweenNodes::routeExists($n1, $n9));
        self::resetNodes($graph);
        $this->assertFalse(RouteBetweenNodes::routeExists($n1, $n10));
        self::resetNodes($graph);
        $this->assertFalse(RouteBetweenNodes::routeExists($n1, $n11));
        self::resetNodes($graph);
        $this->assertFalse(RouteBetweenNodes::routeExists($n1, $n12));
    }

    private static function resetNodes(array $graphNodes) {
        foreach ($graphNodes as $graphNode) {
            $graphNode->reset();
        }
    }
}
