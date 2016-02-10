package Ch03_StacksAndQueues

import groovy.transform.*
import Ch03_StacksAndQueues.utils.Queue

import java.time.Instant

/** Link several queue types, so that the operations can be performed on all, collectively and separately */
class LinkedQueues {
    private queues = new HashMap<Class<Named>, Queue<Named>>().withDefault { new Queue() }
    private position = new HashMap<Named, Instant>().withDefault { Instant.now() }

    void add(Named value) {
        position[value]
        queues[value.class].add(value)
    }
    Named peek() { queues.values()*.peek().min { a, b -> position[a] <=> position[b] } }
    Named remove() { remove(peek().class) }
    def <T extends Named> T remove(Class<T> type) {
        def queue = queues[type]
        T value = queue.remove()
        position.remove(value)
        (queue.empty) && queues.remove(type)
        value
    }
    boolean isEmpty() { queues.isEmpty() }
}

@TupleConstructor @ToString(includePackage = false) class Named { String name }