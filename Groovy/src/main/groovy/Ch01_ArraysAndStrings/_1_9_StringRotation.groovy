package Ch01_ArraysAndStrings

/** Given an isSubString method, find out if one String is the rotation of another */
class _1_9_StringRotation {
    /** Complexity: O(source.size()), uses same amount of space.*/
    static isRotation(String source, String target) {
        (source.size() == target.size()) && isSubString(target + target, source)
    }

    /* Given */
    static isSubString(String source, String target) { source.contains(target) }
}