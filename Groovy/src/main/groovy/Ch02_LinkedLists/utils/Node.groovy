package Ch02_LinkedLists.utils

import groovy.transform.*

@TupleConstructor @EqualsAndHashCode(includes = 'value', includeFields = true) @ToString(includePackage = false)
class Node<T> implements Iterable<Node<T>> {
    static final END_SENTINEL = new Node<>()

    T value
    Node<T> next = END_SENTINEL

    static Node<T> from(Object elems) {
        def preHead = new Node()
        elems.inject(preHead) { Node node, T value -> node.addAfter(value) }
        preHead.next
    }
    def Node<T> copy() { from(toList()) }
    def List<T> toList() { iterator()*.value }

    def replace(Node<T> node) {
        value = node.value
        next = node.next
    }
    def addAfter(T value) { next = new Node(value, next) }
    def addBefore(T value) { new Node(value, this) }

    def isValid() { next != null }

    @Override Iterator<Node<T>> iterator() {
        new Iterator<Node<T>>() {
            def previous = Node.this.addBefore(null)
            @Override boolean hasNext() { previous?.next?.isValid() }
            @Override Node<T> next() { previous = previous?.next }
        }
    }
}
