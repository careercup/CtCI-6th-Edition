package Q1_03_URLify;

import CtCILibrary.AssortedMethods;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author mgobaco on 8/22/16.
 */
public class QuestionTest {

    @Test
    public void testReplaceSpaces() throws Exception {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        assertEquals(12, Question.findLastCharacter(arr));
        Question.replaceSpaces(arr, 13);
        String result = AssortedMethods.charArrayToString(arr);
        assertEquals("Mr%20John%20Smith", result);
    }

    @Test
    public void testFindLastCharacter() throws Exception {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        assertEquals(12, Question.findLastCharacter(arr));

    }
}