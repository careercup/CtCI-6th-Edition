package Ch01_ArraysAndStrings

import static java.lang.Math.abs

/** Calculate the edit distance (insert, remove, replace) between two stings (for simplicity only 0-1 edits) */
class _1_5_EditDistance {
    static isCloseEnough(String a, String b) {
        isCloseEnough(a.toList(), b.toList()) /* avoids AIOBE */
    }

    /** Complexity: O(a.size()) */
    static isCloseEnough(List a, List b) {
        if (a == b) return true

        boolean editsFound = false
        def (i, j) = [0, 0]
        while (i < a.size() || j < b.size()) {
            if (a[i] == b[j]) {
                i++
                j++
            } else if (a[i + 1] == b[j])
                i++
            else if (a[i] == b[j + 1])
                j++
            else if (!editsFound && (a[i + 1] == b[j + 1])) {
                editsFound = true
                i++
                j++
            } else return false
        }

        !editsFound || abs(i - j) == 0
    }
}