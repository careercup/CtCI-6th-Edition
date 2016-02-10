package Ch01_ArraysAndStrings

import spock.lang.Specification
import spock.lang.Unroll

import static Ch01_ArraysAndStrings._1_7_MatrixRotation.rotate

@Unroll class _1_7_MatrixRotationTest extends Specification {
    /*@formatter:off*/
    def 'rotate?'() {
        when:   def copy = matrix as int[][]
        then:   rotate(copy) == result

        when:   3.times{ rotate(copy) }
        then:   copy == matrix

        where:  matrix                                           || result
                []                                               || []
                [[1]]                                            || [[1]]
                [[1,2],[3,4]]                                    || [[3,1],[4,2]]
                [[1,2,3],[4,5,6],[7,8,9]]                        || [[7,4,1],[8,5,2],[9,6,3]]
                [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]] || [[13,9,5,1],[14,10,6,2],[15,11,7,3],[16,12,8,4]]
    }
    /*@formatter:on*/
}
