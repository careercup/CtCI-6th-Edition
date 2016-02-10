package Ch01_ArraysAndStrings

/** Given a string, check whether palindromes can be formed from it */
class _1_4_PalindromePermutation {
    /** Complexity: O(string.size()), uses same amount of space */
    static canBePalindrome(String string) {
        def normalizedString = string.toLowerCase().replaceAll('\\W', '')
        def groups = normalizedString.toList().groupBy()
        def oddGroups = groups.findAll { k, v -> isOdd(v.size()) }
        oddGroups.size() <= 1
    }

    static isOdd(int num) { (num & 1) != 0 }
}