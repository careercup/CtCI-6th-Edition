package Ch03_StacksAndQueues

import Ch03_StacksAndQueues.utils.Queue
import spock.lang.Specification

import static java.lang.Math.PI

class QueueTest extends Specification {
    /*@formatter:off*/
    def 'Queue?'() {
        given:  def source = "$PI".toList()

        when:   'a new queue is empty'
                def queue = new Queue<String>()
        then:   queue.empty

        when:   'consuming a queue yields the correct values'
                source.each {
                    queue.add(it)
                    assert !queue.empty
                }
        then:   source.every { it == queue.remove() }
                queue.empty

        when:   'a consumed queue is usable'
                def value = '0'
                queue.add(value)
        then:   queue.remove() == value
    }
    /*@formatter:on*/
}