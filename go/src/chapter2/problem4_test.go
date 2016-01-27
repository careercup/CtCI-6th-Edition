package chapter2

import (
	"reflect"
	"testing"
)

func TestPivotAroundValue(t *testing.T) {
	vals := []int{1, 10, 20, 4, 7, 12, 3, 25}
	ll := GetLinkedListFromValues(vals)
	ll.PivotAroundValue(11)
	expected := []int{1, 10, 4, 7, 3, 20, 12, 25}
	actual := ll.Slice()
	if !reflect.DeepEqual(expected, actual) {
		t.Fatalf("Expected: %v, actual: %v\n", expected, actual)
	}
}
