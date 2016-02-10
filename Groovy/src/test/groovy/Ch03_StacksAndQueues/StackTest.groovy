package Ch03_StacksAndQueues

import Ch03_StacksAndQueues.utils.Stack
import spock.lang.Specification

import static java.lang.Math.PI

class StackTest extends Specification {
    /*@formatter:off*/
    def 'Stack?'() {
        given:  def source = "$PI".toList()

        when:   'a new stack is empty'
                def stack = new Stack<String>()
        then:   stack.empty

        when:   'consuming a stack yields the correct values'
                source.reverseEach {
                    stack.push(it)
                    assert !stack.empty
                }
        then:   source.every { it == stack.pop() }
                stack.empty

        when:   'a consumed stack is usable'
                def value = '0'
                stack.push(value)
        then:   stack.pop() == value
    }
    /*@formatter:on*/
}