package chapter2

// Using hash table to track duplicates.
// Using remove solution from problem 3.
func (ll *DoublyLinkedList) RemoveDuplicates() {
	seen := make(map[int]struct{})
	node := ll.head
	count := ll.count
	for i := 0; i < count; i++ {
		if _, ok := seen[node.value]; ok {
			ll.removeNode(node)
		} else {
			seen[node.value] = struct{}{}
		}
		if node.next == nil {
			break
		}
		node = node.next
	}
}
