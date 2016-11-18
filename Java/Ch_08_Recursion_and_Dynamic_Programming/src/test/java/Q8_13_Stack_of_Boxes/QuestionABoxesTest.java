package Q8_13_Stack_of_Boxes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by michael on 11/18/16.
 */
public class QuestionABoxesTest {

    @Test
    public void testCreateStack() throws Exception {
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

        List<Box> selectedBoxes = QuestionABoxes.createStack(boxes);
        int height = 0;
        for (Box box: selectedBoxes) {
            height += box.height;
        }
        assertEquals(13, height);
    }
}