package Ch03_StacksAndQueues.utils

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import Ch02_LinkedLists.utils.Node

@EqualsAndHashCode(includeFields = true) @ToString(includePackage = false)
class Stack<T> {
    private Node<T> head = Node.END_SENTINEL

    void push(T value) { head = head.addBefore(value) }
    T peek() { head.value }
    T pop() {
        T value = head.value
        head = head.next
        value
    }
    boolean isEmpty() { !head?.isValid() }
}
