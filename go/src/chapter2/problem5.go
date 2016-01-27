package chapter2

func AddTwoLists(l1, l2 *DoublyLinkedList) int {
	multiplyFactor := 1
	res := 0
	n1, n2 := l1.head, l2.head
	for n1 != nil || n2 != nil {
		if n1 == nil {
			res += multiplyFactor * n2.value
			n2 = n2.next
		} else if n2 == nil {
			res += multiplyFactor * n1.value
			n1 = n1.next
		} else {
			res += multiplyFactor * (n1.value + n2.value)
			n1 = n1.next
			n2 = n2.next
		}
		multiplyFactor *= 10
	}
	return res
}
