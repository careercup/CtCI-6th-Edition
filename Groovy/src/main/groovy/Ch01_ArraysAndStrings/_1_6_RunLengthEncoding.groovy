package Ch01_ArraysAndStrings

/** Perform basic string compression of a string, based on the frequency of letters */
class _1_6_RunLengthEncoding {
    static compress(String input) {
        compress(input.toList()) /* avoids AIOBE */
    }

    /** Complexity: O(input.size()), needs same amount of space */
    static compress(List input) {
        def result = new StringBuilder(input.size())

        def count = 0
        for (def i = 0; i < input.size(); i++) {
            count++
            if (input[i] != input[i + 1]) {
                result += (input[i] + count)
                count = 0
            }
        }

        (result.size() < input.size()) ? result.toString()
                                       : input.join()
    }
}