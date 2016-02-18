package Ch01_ArraysAndStrings

import static java.lang.Character.isLetter

/** Given a string, check whether palindromes can be formed from it */
class _1_4_PalindromePermutation {
    static canBePalindrome(String string) {
        def linearLinear = canBePalindrome_Linear_Linear(string)
        def linear = canBePalindrome_Linear(string)

        assert linearLinear == linear
        linear
    }

    /** Complexity: O(string.size()), uses same amount of space */
    static canBePalindrome_Linear_Linear(String string) {
        def normalizedString = string.toLowerCase().replaceAll('\\W', '')
        def groups = normalizedString.toList().groupBy()
        def oddGroups = groups.findAll { k, v -> isOdd(v.size()) }
        oddGroups.size() <= 1
    }
    static isOdd(int num) { (num & 1) != 0 }

    /** Complexity: O(string.size()), uses constant space */
    static canBePalindrome_Linear(String string) {
        def groups = new BitSet()
        for (int c : string.toLowerCase())
            isLetter(c) && groups.flip(c)
        groups.cardinality() < 2;
    }
}