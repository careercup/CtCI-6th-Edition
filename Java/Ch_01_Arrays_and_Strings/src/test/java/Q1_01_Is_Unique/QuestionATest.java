package Q1_01_Is_Unique;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author mgobaco on 6/23/16.
 */
public class QuestionATest {

    @Test
    public void testIsUniqueChars() {
        assertEquals(true, QuestionA.isUniqueChars("abcde"));
        assertEquals(false, QuestionA.isUniqueChars("hello"));
        assertEquals(false, QuestionA.isUniqueChars("apple"));
        assertEquals(true, QuestionA.isUniqueChars("kite"));
        assertEquals(true, QuestionA.isUniqueChars("padle"));
    }

}