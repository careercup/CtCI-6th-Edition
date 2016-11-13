package Q1_05_One_Away;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author mgobaco on 8/22/16.
 */
public class QuestionATest {

    @Test
    public void testOneEditAway() throws Exception {
        String a = "pse";
        String b = "pale";
        String c = "pales";
        boolean isOneEdit = QuestionA.oneEditAway(a, b);
        assertEquals(false, isOneEdit);

        isOneEdit = QuestionA.oneEditAway(c, b);
        assertEquals(true, isOneEdit);
    }
}