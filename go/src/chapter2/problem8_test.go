package chapter2

import (
	"testing"
)

// Create a list with given values.
// Point tail to given index, creating a loop.
func CreateLoopedList(vals []int, index int) *DoublyLinkedList {
	ll := GetLinkedListFromValues(vals)
	ll.tail.next = ll.getNode(index)
	return ll
}

func TestFindLoopNodeNegative(t *testing.T) {
	cases := []struct {
		vals []int
	}{
		{
			[]int{1, 2, 3, 4, 5},
		},
		{
			[]int{1},
		},
		{
			[]int{},
		},
	}
	for _, c := range cases {
		ll := GetLinkedListFromValues(c.vals)
		actual := ll.FindLoopNode()
		if actual != nil {
			t.Fatalf("Expected: nil, actual: %v\n", actual)
		}
	}
}

func TestFindLoopNodePositive(t *testing.T) {
	cases := []struct {
		vals  []int
		index int
	}{
		{
			[]int{100, 101, 102, 103, 104},
			0,
		},
		{
			[]int{100, 101, 102, 103, 104},
			2,
		},
		{
			[]int{100, 101, 102, 103, 104},
			4,
		},
	}
	for _, c := range cases {
		ll := CreateLoopedList(c.vals, c.index)
		actual := ll.FindLoopNode()
		if actual.value != c.index+100 {
			t.Fatalf("Expected: %v, actual: %v\n", c.index, actual)
		}
	}
}
