package Q1_04_Palindrome_Permutation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author mgobaco on 8/22/16.
 */
public class QuestionBTest {

    @Test
    public void testIsPermutationOfPalindrome() throws Exception {
        String phrase = "aba";
        assertEquals(true, QuestionB.isPermutationOfPalindrome(phrase));
        phrase = "abac";
        assertEquals(false, QuestionB.isPermutationOfPalindrome(phrase));
    }
}