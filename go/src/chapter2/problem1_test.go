package chapter2

import (
	"reflect"
	"testing"
)

func TestRemoveDuplicates(t *testing.T) {
	vals := []int{1, 1, 1, 2, 3, 3, 4, 5, 5, 6}
	ll := GetLinkedListFromValues(vals)
	ll.RemoveDuplicates()
	expected := []int{1, 2, 3, 4, 5, 6}
	actual := ll.Slice()
	if !reflect.DeepEqual(expected, actual) {
		t.Fatalf("Expected: %v, actual: %v\n", expected, actual)
	}
}
