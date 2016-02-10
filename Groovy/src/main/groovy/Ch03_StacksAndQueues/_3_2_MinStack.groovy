package Ch03_StacksAndQueues

import Ch03_StacksAndQueues.utils.Stack

/** Create stack with O(1) minimum */
class MinStack<T> extends Stack<T> {
    private final mins = new Stack<T>()

    @Override void push(T value) {
        (mins.empty || (value <= peekMin())) && mins.push(value) /* equal elements have to be repeated */
        super.push(value)
    }
    @Override T pop() {
        (peek() == peekMin()) && mins.pop()
        super.pop()
    }
    T peekMin() { mins.peek() }
}