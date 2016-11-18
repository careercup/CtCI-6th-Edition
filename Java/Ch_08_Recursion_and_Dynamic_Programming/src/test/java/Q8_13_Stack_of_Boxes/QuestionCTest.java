package Q8_13_Stack_of_Boxes;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by michael on 11/17/16.
 */
public class QuestionCTest {

    @Test
    public void createStack() throws Exception {
        Box[] boxList = {
                new Box(6, 4, 4),
                new Box(8, 6, 2),
                new Box(5, 3, 3),
                new Box(7, 8, 3),
                new Box(4, 2, 2),
                new Box(9, 7, 3)};
        ArrayList<Box> boxes = new ArrayList<Box>();
        for (Box b : boxList) {
            boxes.add(b);
        }

        int height = QuestionC.createStack(boxes);
        assertEquals(13, height);
    }
}