package chapter2

func (ll *DoublyLinkedList) removeNode(node *node) {
	if ll.head == node {
		ll.head = node.next
	}
	if ll.tail == node {
		ll.tail = node.prev
	}
	if node.prev != nil {
		node.prev.next = node.next
	}
	if node.next != nil {
		node.next.prev = node.prev
	}
	ll.count--
}

func (ll *DoublyLinkedList) Remove(index int) {
	ll.removeNode(ll.getNode(index))
}
