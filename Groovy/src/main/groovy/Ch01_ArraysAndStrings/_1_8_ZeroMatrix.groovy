package Ch01_ArraysAndStrings
/** Zero out the row an column of each 0 element in a matrix */
class _1_8_ZeroMatrix {
    /** Complexity: O(width*height), uses O(width+height) space.
     *  Note: we could mark the occurrence on the first column/row also, to reduce space usage, but would complicate the algorithm too much. */
    static zeroOutRowsAndColumns(int[][] matrix) {
        def (markedColumns, markedRows) = getMarkedColumnsAndRows(matrix) { it == 0 }

        zeroOutColumns(matrix, markedColumns)
        zeroOutRows(matrix, markedRows)

        matrix
    }

    static zeroOutColumns(int[][] matrix, Set markedColumns) {
        markedColumns.each { int column ->
            matrix.eachWithIndex { _, int row ->
                matrix[row][column] = 0
            }
        }
    }
    static zeroOutRows(int[][] matrix, Set markedRows) {
        markedRows.each { int row ->
            matrix[row].eachWithIndex { _, int column ->
                matrix[row][column] = 0
            }
        }
    }

    static getMarkedColumnsAndRows(int[][] matrix, Closure predicate) {
        def (Set markedColumns, Set markedRows) = [[], []]
        matrix.eachWithIndex { int[] rowElements, int row ->
            rowElements.eachWithIndex { int entry, int column ->
                if (predicate(entry)) {
                    markedColumns += column
                    markedRows += row
                }
            }
        }
        [markedColumns, markedRows]
    }
}