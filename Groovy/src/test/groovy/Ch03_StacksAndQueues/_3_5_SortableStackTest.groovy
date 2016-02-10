package Ch03_StacksAndQueues

import spock.lang.Specification

import static java.lang.Math.*

class _3_5_SortableStackTest extends Specification {
    /*@formatter:off*/
    def 'chainedStack?'() {
        given:  def source = "$PI$E".toList()

        when:   'a new stack is empty'
                def stack = new SortableStack()
        then:   stack.empty

        when:   'consuming a stack yields the correct value'
                source.each {
                    stack.push(it)
                    assert !stack.empty
                }
                stack.sort()
        then:   source.sort().each { assert it == stack.pop() }
                stack.empty
    }
    /*@formatter:on*/
}
