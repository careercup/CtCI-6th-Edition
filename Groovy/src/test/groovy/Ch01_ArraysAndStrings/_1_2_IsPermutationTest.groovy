package Ch01_ArraysAndStrings

import spock.lang.Specification
import spock.lang.Unroll

import static Ch01_ArraysAndStrings._1_2_IsPermutation.isPermutation

@Unroll class _1_2_IsPermutationTest extends Specification {
    /*@formatter:off*/
    def 'IsPermutation?'() {
        expect: isPermutation(original.toList(), candidate.toList()) == result
        where:  original  | candidate || result
                '1234'    | '3142'    || true
                '1234567' | '5371624' || true
                '1234'    | '3141'    || false
                '1234'    | '12345'   || false
    }
    /*@formatter:on*/
}
