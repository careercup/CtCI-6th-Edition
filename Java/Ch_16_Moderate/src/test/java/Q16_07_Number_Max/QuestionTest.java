package Q16_07_Number_Max;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * @author mgobaco on 11/13/16.
 */
public class QuestionTest {

    @Test
    public void testGetMaxDifferentSignsA() throws Exception {

        int a = 26;
        int b = -15;

        assertEquals(a,  Question.getMax(a, b));


    }

    @Test
    public void testGetMaxDifferentSignsB() throws Exception {

        int b = 26;
        int a = -15;

        assertEquals(b,  Question.getMax(a, b));


    }

    @Test
    public void testGetMaxOverflow() throws Exception {

        int a;
        int b;

        a = -15;
        b = 2147483647;

        assertEquals(b,  Question.getMax(a, b));


    }

    @Test
    public void testGetMaxSameSignsA() throws Exception {

        int a = 26;
        int b = 15;

        assertEquals(a,  Question.getMax(a, b));

    }

    @Test
    public void testGetMaxSameSignsB() throws Exception {

        int b = 26;
        int a = 15;

        assertEquals(b,  Question.getMax(a, b));

    }


}