package Ch01_ArraysAndStrings

import static java.lang.Math.max

/** Replace all instanced of a String in a StringBuilder */
class _1_3_URLify {
    static urlify(String string, int length, String search, String replacement) {
        def result = urlify(new StringBuilder(string), length, search, replacement)
        assert result.size() == string.size()
        result.toString()
    }

    /** Complexity: O(string.length * search.length()), no additional space used */
    static urlify(StringBuilder string, int length, String search, String replacement) {
        assert (search.length() <= replacement.length()) && (length <= string.length())

        def (writeIndex, readIndex) = [string.size() - 1, length - 1]
        while (readIndex >= 0) {
            if (string[max(0, readIndex - search.length() + 1)..readIndex] == search) {
                string[max(0, writeIndex - replacement.length() + 1)..writeIndex] = replacement

                readIndex -= search.length()
                writeIndex -= replacement.length()
            } else {
                string[writeIndex..writeIndex] = string[readIndex]

                readIndex -= 1
                writeIndex -= 1
            }
        }

        string
    }
}