package Q1_01_Is_Unique;

import org.junit.Test;

/**
 * @author mgobaco on 6/23/16.
 */
public class QuestionATest {

    @Test
    public void isUniqueChars() {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            boolean wordA =  QuestionA.isUniqueChars(word);
            boolean wordB =  QuestionB.isUniqueChars(word);
            if (wordA == wordB) {
                System.out.println(word + ": " + wordA);
            } else {
                System.out.println(word + ": " + wordA + " vs " + wordB);
            }
        }
    }

}