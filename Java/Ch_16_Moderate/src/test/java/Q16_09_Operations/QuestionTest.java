package Q16_09_Operations;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * @author mgobaco on 11/13/16.
 */
public class QuestionTest {

    @Test
    public void testNegate() throws Exception {
        assertEquals(-5, Question.negate(5));
    }

    @Test
    public void testNegateOptimized() throws Exception {
        assertEquals(-5, Question.negateOptimized(5));
    }

    @Test
    public void testMinus() throws Exception {
        assertEquals(2, Question.minus(5, 3));
        assertEquals(8, Question.minus(5, -3));
    }

    @Test
    public void testAbs() throws Exception {
        assertEquals(3, Question.abs(3));
        assertEquals(3, Question.abs(-3));
    }

    @Test
    public void testMultiply() throws Exception {
        assertEquals(15, Question.multiply(5, 3));
        assertEquals(-15, Question.multiply(5, -3));
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(1, Question.divide(5, 3));
        assertEquals(-1, Question.divide(5, -3));
    }
}