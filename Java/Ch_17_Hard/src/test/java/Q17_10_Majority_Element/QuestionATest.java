package Q17_10_Majority_Element;

import org.junit.Test;

import static Q17_10_Majority_Element.QuestionA.findMajorityElement;
import static Q17_10_Majority_Element.QuestionA.validate;
import static org.junit.Assert.assertEquals;

/**
 * @author mgobaco on 6/23/16.
 */
public class QuestionATest {

    @Test
    public void testValidate() throws Exception {
        int[] array = {0, 0, 1, 2, 2, 0, 1, 0, 1, 1, 1, 1, 1};
        assertEquals(true, validate(array, 1));
        assertEquals(false, validate(array, 0));
    }

    @Test
    public void testFindMajorityElement() throws Exception {
        int[] array = {0, 0, 1, 2, 2, 0, 1, 0, 1, 1, 1, 1, 1};

        assertEquals(1, findMajorityElement(array));
    }
}