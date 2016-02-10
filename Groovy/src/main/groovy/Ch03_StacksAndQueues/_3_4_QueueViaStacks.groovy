package Ch03_StacksAndQueues

import groovy.transform.ToString
import Ch03_StacksAndQueues.utils.Stack

/** Create a queue using two stacks */
@ToString(includes = 'head', includePackage = false)
class QueueViaStacks<T> {
    private main = new Stack<T>()
    private reverse = new Stack<T>()

    void add(T value) { move(reverse, main).push(value) }
    T peek() { move(main, reverse).peek() }
    T remove() { move(main, reverse).pop() }
    boolean isEmpty() { main.empty && reverse.empty }

    /** Complexity: O(from.size) */
    private static move(Stack<T> from, Stack<T> to) {
        while (!from.empty)
            to.push(from.pop())
        to
    }
}
