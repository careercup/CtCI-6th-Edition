package chapter2

import (
	"reflect"
	"testing"
)

func TestLinkedListInsertAndGet(t *testing.T) {
	ll := GetLinkedList()
	vals := []int{1, 2, 3, 4}
	for _, val := range vals {
		ll.Insert(val)
	}
	actual := make([]int, len(vals))
	for i, _ := range vals {
		actual[i] = ll.Get(i)
	}
	if ll.Len() != len(vals) {
		t.Fatalf("Expected: %d, actual: %d\n", len(vals), ll.Len())
	}
	if !reflect.DeepEqual(actual, vals) {
		t.Fatalf("Expected: %v, actual: %v\n", vals, actual)
	}
}

func TestLinkedListConstructor(t *testing.T) {
	vals := []int{1, 2, 3, 4}
	ll := GetLinkedListFromValues(vals)
	actual := make([]int, len(vals))
	for i, _ := range vals {
		actual[i] = ll.Get(i)
	}
	if ll.Len() != len(vals) {
		t.Fatalf("Expected: %d, actual: %d\n", len(vals), ll.Len())
	}
	if !reflect.DeepEqual(actual, vals) {
		t.Fatalf("Expected: %v, actual: %v\n", vals, actual)
	}
}
