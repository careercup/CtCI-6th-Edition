package chapter2

// Don't use prev to simulate singly linked list.
// Assume k=0 means tail, k=1 one before tail etc.
// Using the length of the list.
func (ll *DoublyLinkedList) KFromTail(k int) int {
	node := ll.head
	for i := 0; i < ll.count-k-1; i++ {
		node = node.next
	}
	return node.value
}

// Without knowledge of the length of the list.
func (ll *DoublyLinkedList) KFromTail2(k int) int {
	first, second := ll.head, ll.head
	for i := 0; i < k+1; i++ {
		second = second.next
		if second == nil {
			return -1
		}
	}
	for second != nil {
		first = first.next
		second = second.next
	}
	return first.value
}
