package Ch03_StacksAndQueues

import groovy.transform.ToString

/** Chain stacks, once they're full */
@ToString(includes = 'stacks', includePackage = false)
class ChainedStack<T> {
    private final List<List<T>> stacks = []
    private final int capacity

    ChainedStack(int capacity) { this.capacity = capacity }

    void push(T value) {
        (empty || (stacks.last().size() == capacity)) && (stacks << [])
        stacks.last() << value
    }
    T peek() { stacks.last().last() }
    T pop() {
        def last = stacks.last()
        def value = last.pop()
        last.empty && stacks.pop()
        value
    }
    boolean isEmpty() { stacks.empty }
}
