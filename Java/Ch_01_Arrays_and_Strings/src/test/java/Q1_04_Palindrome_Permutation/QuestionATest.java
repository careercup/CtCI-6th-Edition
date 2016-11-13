package Q1_04_Palindrome_Permutation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author mgobaco on 8/22/16.
 */
public class QuestionATest {

    @Test
    public void testCheckMaxOneOdd() throws Exception {
        int[] numbers = {1, 2, 6, 4};
        assertEquals(true, QuestionA.checkMaxOneOdd(numbers));
    }

    @Test
    public void testIsPermutationOfPalindrome() throws Exception {
        String phrase = "aba";
        assertEquals(true, QuestionA.isPermutationOfPalindrome(phrase));
        phrase = "abac";
        assertEquals(false, QuestionA.isPermutationOfPalindrome(phrase));
    }
}