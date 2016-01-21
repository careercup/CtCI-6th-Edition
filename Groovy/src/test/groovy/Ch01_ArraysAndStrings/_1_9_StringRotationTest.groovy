package Ch01_ArraysAndStrings

import spock.lang.Specification
import spock.lang.Unroll

import static Ch01_ArraysAndStrings._1_9_StringRotation.isRotation

@Unroll class _1_9_StringRotationTest extends Specification {
    /*@formatter:off*/
    def 'rotate?'() {
        expect: isRotation(source, target) == result
        where:  source        | target        || result
                ''            | ''            || true
                'a'           | 'a'           || true
                'waterbottle' | 'erbottlewat' || true
                'apple'       | 'pleap'       || true

                'ab'          | 'aba'         || false
                'camera'      | 'macera'      || false
    }
    /*@formatter:on*/
}