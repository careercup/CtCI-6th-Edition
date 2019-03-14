import java.util.BitSet;

public class BitManipulation {

    private static final String WORD = "octa cat t t";

    public static void main(String[] args) {

        System.out.println(WORD + "\n" + canPalindrome(WORD));
    }


    private static boolean canPalindrome(String wordStr) {

        BitSet bitSet = new BitSet(256);
        for (int i = 0; i < wordStr.length(); i++) {
            char letter = wordStr.charAt(i);
            if (letter != ' ') {    // space char ' ' does not affect the result
                bitSet.flip(letter);
            }
        }

        int cardinality = bitSet.cardinality(); //represents '1' bits in BitSet
        return cardinality <= 1;   //Palindrome can hold 0-1 chars with ODD count
    }


}
