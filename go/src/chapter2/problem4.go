package chapter2

func (ll *DoublyLinkedList) PivotAroundValue(value int) {
	lower := GetLinkedList()
	higher := GetLinkedList()
	node := ll.head
	for i := 0; i < ll.count; i++ {
		next := node.next
		if node.value <= value {
			lower.insertNode(node)
		} else {
			higher.insertNode(node)
		}
		node = next
	}
	// Join higher and lower lists, and replace ll.
	lower.tail.next = higher.head
	higher.head.prev = lower.tail
	ll.tail = higher.tail
	ll.head = lower.head
}
