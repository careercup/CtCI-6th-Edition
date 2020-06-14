package Q1_09_String_Rotation;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class QuestionTest {

    @Test
    public void isRotation() {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};

        Map<String[], Boolean> results = new HashMap<>();

        results.put(pairs[0], true);
        results.put(pairs[1], true);
        results.put(pairs[2], false);
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = Question.isRotation(word1, word2);
            assertEquals(results.get(pair), is_rotation);
        }
    }
}