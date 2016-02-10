package Ch01_ArraysAndStrings
/** Given a square matrix, rotate it 90° */
class _1_7_MatrixRotation {
    static rotate(int[][] matrix) {
        def copy = rotateCopy(matrix, matrix.length)
        def original = rotateInPlace(matrix, matrix.length)

        assert copy == original
        original
    }

    /** Complexity: O(width*height), uses same amount of extra space */
    static rotateCopy(int[][] matrix, int size) {
        def result = new int[size][size]
        matrix.eachWithIndex { int[] rowElements, int row ->
            rowElements.eachWithIndex { int entry, int column ->
                result[column][size - row - 1] = entry
            }
        }
        result
    }

    /** Complexity: O(width*height), doesn't use extra space */
    static rotateInPlace(int[][] matrix, int size) {
        for (row in 0..<(size / 2))
            for (column in row..<(size - row - 1))
                rotate(matrix, column, row, size - 1)
        matrix
    }

    static rotate(int[][] matrix, int column, int row, int size) {
        def previous = matrix[row][column]
        4.times {
            (row, column) = [column, size - row]

            def current = matrix[row][column]
            matrix[row][column] = previous
            previous = current
        }
    }
}