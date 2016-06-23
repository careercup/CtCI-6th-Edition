package Q1_02_Check_Permutation;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author mgobaco on 6/23/16.
 */
public class QuestionBTest {

    @Test
    public void testPermutation() throws Exception {
        String[][] pairs = {{"apple", "papel"},
                {"carrot", "tarroc"},
                {"hello", "llloh"}};

        Map<String[], Boolean> pairsTest = new HashMap<String[], Boolean>();
        pairsTest.put(pairs[0], true);
        pairsTest.put(pairs[1], true);
        pairsTest.put(pairs[2], false);
        for (String[] pair : pairsTest.keySet()) {
            String word1 = pair[0];
            String word2 = pair[1];
            assertEquals(pairsTest.get(pair), QuestionB.permutation(word1, word2));
        }
    }
}