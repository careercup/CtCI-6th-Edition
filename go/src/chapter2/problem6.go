package chapter2

// Using doubly linked list which remembers head & tail.
func (ll *DoublyLinkedList) IsPalindrome() bool {
	if ll.head == nil || ll.head == ll.tail {
		return true
	}
	h := ll.head
	t := ll.tail
	for {
		if h.value != t.value {
			return false
		}
		h = h.next
		t = t.prev
		if h == t || h.prev == t {
			break
		}
	}
	return true
}
