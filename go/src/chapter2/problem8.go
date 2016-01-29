package chapter2

func (ll *DoublyLinkedList) FindLoopNode() *node {
	fast, slow := ll.head, ll.head

	for fast != nil && fast.next != nil {
		slow = slow.next
		fast = fast.next.next
		if slow == fast {
			break
		}
	}

	if fast == nil || fast.next == nil {
		return nil
	}

	slow = ll.head
	for slow != fast {
		slow = slow.next
		fast = fast.next
	}
	return fast
}
