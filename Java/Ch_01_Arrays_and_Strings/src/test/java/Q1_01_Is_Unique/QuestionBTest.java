package Q1_01_Is_Unique;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author mgobaco on 6/23/16.
 */
public class QuestionBTest {

    @Test
    public void testIsUniqueChars() throws Exception {
        assertEquals(true, QuestionB.isUniqueChars("abcde"));
        assertEquals(false, QuestionB.isUniqueChars("hello"));
        assertEquals(false, QuestionB.isUniqueChars("apple"));
        assertEquals(true, QuestionB.isUniqueChars("kite"));
        assertEquals(true, QuestionB.isUniqueChars("padle"));

    }
}