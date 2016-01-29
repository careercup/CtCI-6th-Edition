package chapter2

import (
	"testing"
)

func TestAreIntersectingPositive(t *testing.T) {
	// Intersecting in middle with l2 shorter.
	l1 := GetLinkedListFromValues([]int{1, 2, 3, 4, 5})
	l2 := GetLinkedList()
	l2.Insert(7)
	l2.tail.next = l1.getNode(2)
	l2.count += 3
	actual := AreIntersecting(l1, l2)
	if !actual {
		t.Fatalf("Expected: true, actual: %v\n", actual)
	}
	// Intersecting at start.
	l3 := GetLinkedList()
	l3.head = l1.head
	l3.count += 5
	actual = AreIntersecting(l1, l3)
	if !actual {
		t.Fatalf("Expected: true, actual: %v\n", actual)
	}
	// Intersecting in middle with l4 longer.
	l4 := GetLinkedList()
	l4.Insert(7)
	l4.Insert(6)
	l4.Insert(5)
	l4.Insert(4)
	l4.tail.next = l1.getNode(1)
	l4.count += 4
	actual = AreIntersecting(l1, l4)
	if !actual {
		t.Fatalf("Expected: true, actual: %v\n", actual)
	}
}

func TestAreIntersectingNegative(t *testing.T) {
	cases := []struct {
		l1, l2   *DoublyLinkedList
		expected bool
	}{
		{
			GetLinkedListFromValues([]int{7, 1, 6}),
			GetLinkedListFromValues([]int{5, 9, 2}),
			false,
		},
		{
			GetLinkedListFromValues([]int{7, 1, 6}),
			GetLinkedListFromValues([]int{2, 4}),
			false,
		},
		{
			GetLinkedListFromValues([]int{}),
			GetLinkedListFromValues([]int{7, 1, 6}),
			false,
		},
		{
			GetLinkedListFromValues([]int{}),
			GetLinkedListFromValues([]int{}),
			false,
		},
	}
	for _, c := range cases {
		actual := AreIntersecting(c.l1, c.l2)
		if c.expected != actual {
			t.Fatalf("Expected: %v, actual: %v\n", c.expected, actual)
		}
	}
}
