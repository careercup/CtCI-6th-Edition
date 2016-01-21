package Ch01_ArraysAndStrings

import spock.lang.Specification
import spock.lang.Unroll

import static Ch01_ArraysAndStrings._1_8_ZeroMatrix.zeroOutRowsAndColumns

@Unroll class _1_8_ZeroMatrixTest extends Specification {
    /*@formatter:off*/
    def 'rotate?'() {
        expect: zeroOutRowsAndColumns(matrix as int[][]) == result
        where:  matrix                                           || result
                []                                               || []

                [[1]]                                            || [[1]]
                [[0]]                                            || [[0]]

                [[1,2],[3,4]]                                    || [[1,2],[3,4]]
                [[0,2],[3,4]]                                    || [[0,0],[0,4]]
                [[1,0],[3,4]]                                    || [[0,0],[3,0]]
                [[1,2],[0,4]]                                    || [[0,2],[0,0]]
                [[1,2],[3,0]]                                    || [[1,0],[0,0]]

                [[1,2,3],[4,5,6],[7,8,9]]                        || [[1,2,3],[4,5,6],[7,8,9]]
                [[0,2,3],[4,5,6],[7,8,0]]                        || [[0,0,0],[0,5,0],[0,0,0]]
                [[0,0,0],[4,5,6],[7,8,9]]                        || [[0,0,0],[0,0,0],[0,0,0]]
                [[0,2,3],[0,5,6],[0,8,9]]                        || [[0,0,0],[0,0,0],[0,0,0]]

                [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]] || [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
                [[1,2,3,4],[5,0,7,8],[9,10,11,12],[13,14,15,16]] || [[1,0,3,4],[0,0,0,0],[9,0,11,12],[13,0,15,16]]
    }
    /*@formatter:on*/
}
