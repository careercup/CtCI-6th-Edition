package chapter2

import ()

type DoublyLinkedList struct {
	head  *node
	tail  *node
	count int
}

type node struct {
	value int
	next  *node
	prev  *node
}

func GetLinkedList() *DoublyLinkedList {
	return &DoublyLinkedList{nil, nil, 0}
}

func GetLinkedListFromValues(vals []int) *DoublyLinkedList {
	ll := GetLinkedList()
	if len(vals) == 0 {
		return ll
	}
	for _, val := range vals {
		ll.Insert(val)
	}
	return ll
}

// Insert at end.
func (ll *DoublyLinkedList) Insert(val int) {
	newNode := &node{value: val}
	ll.count++
	if ll.tail == nil {
		ll.head, ll.tail = newNode, newNode
		return
	} else {
		ll.tail.next = newNode
		newNode.prev = ll.tail
		ll.tail = newNode
		return
	}
}

func (ll *DoublyLinkedList) Remove(index int) {
	ll.removeNode(ll.getNode(index))
}

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

func (ll *DoublyLinkedList) getNode(index int) *node {
	node := ll.head
	for i := 0; i < index; i++ {
		node = node.next
	}
	return node
}

// Mostly used for testing.
func (ll *DoublyLinkedList) Slice() []int {
	slice := make([]int, ll.count)
	node := ll.head
	for i := 0; i < ll.count; i++ {
		slice[i] = node.value
		node = node.next
	}
	return slice
}

func (ll *DoublyLinkedList) Get(index int) int {
	return ll.getNode(index).value
}

func (ll *DoublyLinkedList) Len() int {
	return ll.count
}
