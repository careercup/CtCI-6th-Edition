package Ch02_LinkedLists

import Ch02_LinkedLists.utils.Node
import spock.lang.*

import static java.lang.Math.*
import static Ch02_LinkedLists._2_5_SumLists.*

@Unroll class _2_5_SumListsTest extends Specification {
    /*@formatter:off*/
    def 'reverse?'() {
        when:   def head = Node.from(source.toList())
        then:   reverse(head).toList() == source.toList().reverse()
        where:  source | _
                "$PI"  | _
                "$E"   | _
    }

    def 'sum?'() {
        when:   def head1 = Node.from(asDigits(num1))
                def head2 = Node.from(asDigits(num2))
        then:   sum(head1, head2).toList() == asDigits(num1 + num2)
        where:  num1       | num2
                1          | 2
                10         | 2
                12         | 1234
                1234       | 12
                9999       | 1
                987        | 123
                1          | 99
                3141592653 | 589793
    }
    /*@formatter:on*/

    def asDigits(Number num) { num.toString()*.toInteger() }
}
