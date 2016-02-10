package Ch01_ArraysAndStrings

import static java.util.Collections.binarySearch

/** Determine if a string has unique characters */
class _1_1_IsUnique {
    static isUnique(List values) {
        def squared = isUnique_Squared(values.toList())
        def linearithmic = isUnique_Linearithmic(values.toList())
        def linearLinear = isUnique_Linear_Linear(values.toList())
        def linear = isUnique_Linear(values.toList())

        assert [squared, linearithmic, linearLinear].every { it == linear }

        linear
    }

    /** Complexity: O(values.size()**2), no additional space */
    static isUnique_Squared(List values) {
        for (i in values.indices)
            if (values.findLastIndexOf(i + 1) { it == values[i] } >= 0)
                return false
        true
    }

    /** Complexity: O(n log n), where n = values.size(), no additional space. Could be O(n) also, with O(n) space */
    static isUnique_Linearithmic(List values) {
        values.sort()
        for (i in values.indices)
            if (binarySearch(values, values[i]) != i)
                return false
        true
    }

    /** Complexity: O(values.size()), but needs same amount of space */
    static isUnique_Linear_Linear(List values) {
        Set seen = []
        values.every { seen.add(it) }
    }

    /** Complexity: O(values.size()), O(1) space */
    static isUnique_Linear(List values) {
        def seen = new BitSet()
        values.every {
            int c = it
            def result = seen[c]
            seen.set(c)
            !result
        }
    }
}