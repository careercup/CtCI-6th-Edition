package Q8_13_Stack_of_Boxes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by michael on 11/18/16.
 */
public class QuestionABoxes {
    public static List<Box> createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;
        List<Box> selectedBoxes = new ArrayList<>();
        for (int i = 0; i < boxes.size(); i++) {
            List<Box> stackedBoxes = createStack(boxes, i);
            int height = 0;
            for (Box box: stackedBoxes) {
                height += box.height;
            }
            if (height > maxHeight) {
                maxHeight = height;
                selectedBoxes = stackedBoxes;
            }
        }
        return selectedBoxes;
    }

    public static List<Box> createStack(ArrayList<Box> boxes, int bottomIndex) {
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        List<Box> selectedBoxes = new ArrayList<>();
        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                List<Box> stackedBoxes = createStack(boxes, i);
                int height = 0;
                for (Box box: stackedBoxes) {
                    height += box.height;
                }
                if (height > maxHeight) {
                    maxHeight = height;
                    selectedBoxes = stackedBoxes;
                }
            }
        }
        //maxHeight += bottom.height;
        selectedBoxes.add(bottom);
        return selectedBoxes;
    }
}
