package Ch01_ArraysAndStrings

/** Determine if two strings are each other's permutation */
class _1_2_IsPermutation {
    static isPermutation(List original, List candidate) {
        def linearithmic = isPermutation_Linearithmic(original.toList(), candidate.toList()) /* avoid mutating the originals */
        def linear = isPermutation_Linear(original, candidate)

        assert linearithmic == linear

        linear
    }

    /** Complexity: O(n log n), where n = original.size(), uses no additional space */
    static isPermutation_Linearithmic(List original, List candidate) {
        (original.size() == candidate.size() /* avoid sorting the second one, if their sizes don't match */
        && original.sort() == candidate.sort())
    }

    /** Complexity: O(original.size()), uses same amount of space */
    static isPermutation_Linear(List original, List candidate) {
        (original.size() == candidate.size()
        && original.groupBy() == candidate.groupBy())
    }
}