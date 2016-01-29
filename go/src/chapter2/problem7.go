package chapter2

// Only use next to simulate singly linked list.
func AreIntersecting(l1, l2 *DoublyLinkedList) bool {
	n1, n2 := l1.head, l2.head
	if l1.count > l2.count {
		for i := 0; i < l1.count-l2.count; i++ {
			n1 = n1.next
		}
	}
	if l2.count > l1.count {
		for i := 0; i < l2.count-l1.count; i++ {
			n2 = n2.next
		}
	}
	for n1 != nil {
		if n1 == n2 {
			return true
		}
		n1, n2 = n1.next, n2.next
	}
	return false
}
