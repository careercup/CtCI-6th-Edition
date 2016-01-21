package Ch01_ArraysAndStrings

import spock.lang.Specification

import static Ch01_ArraysAndStrings._1_1_IsUnique.isUnique

class _1_1_IsUniqueTest extends Specification {
    /*@formatter:off*/
    def 'IsUnique?'() {
        when:   def referenceIsUnique = (values.unique(false) == values)
        then:   isUnique(values) == referenceIsUnique
        where:  values = generateRandomString(10, 'a'..'z').toList()
    }
    /*@formatter:on*/

    static generateRandomString(int size, List alphabet) {
        def random = new Random()
        (0..<size).collect { alphabet[random.nextInt(alphabet.size())] }
                  .join()
    }
}
