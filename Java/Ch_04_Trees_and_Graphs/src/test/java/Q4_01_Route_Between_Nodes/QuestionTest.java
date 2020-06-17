package Q4_01_Route_Between_Nodes;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest {

    @Test
    public void search() {
        Graph g = Question.createNewGraph();
        Node[] n = g.getNodes();
        Node start = n[3];
        Node end = n[5];
        assertEquals(true, (Question.search(g, start, end)));
    }
}