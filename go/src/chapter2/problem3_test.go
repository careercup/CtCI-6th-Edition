package chapter2

import (
	"reflect"
	"testing"
)

func TestRemoveNode(t *testing.T) {
	vals := []int{1, 1, 1, 2, 3, 3, 4, 5, 5, 6}
	ll := GetLinkedListFromValues(vals)
	ll.Remove(3)
	expected := []int{1, 1, 1, 3, 3, 4, 5, 5, 6}
	actual := ll.Slice()
	if !reflect.DeepEqual(expected, actual) {
		t.Fatalf("Expected: %v, actual: %v\n", expected, actual)
	}
}
