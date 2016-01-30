package chapter3

import (
	"reflect"
	"sort"
	"testing"
)

func TestSliceMultiStackPushThenPop(t *testing.T) {
	// Set up data.
	s := GetSetOfStacks(3)
	vals := []int{1, 2, 3, 4, 5, 6, 7, 8, 9}

	for _, val := range vals {
		s.Push(val)
	}
	actual := make([]int, len(vals))
	for i, _ := range vals {
		val, err := s.Pop()
		if err != nil {
			t.Fatalf("Unexpected error: %v\n", err)
		}
		actual[i] = val
	}
	sort.Sort(sort.Reverse(intSlice(vals)))
	if !reflect.DeepEqual(actual, vals) {
		t.Fatalf("Expected: %v, actual: %v\n", vals, actual)
	}
}

func TestSliceMultiStackPushThenPopAt(t *testing.T) {
	// Set up data.
	s := GetSetOfStacks(3)
	vals := []int{1, 2, 3, 4, 5, 6, 7, 8, 9}

	for _, val := range vals {
		s.Push(val)
	}

	// Push then popAt in random palces.
	popOrder := []int{1, 1, 2, 3, 2, 3}
	actual := make([]int, len(popOrder))
	for i, stack := range popOrder {
		val, err := s.PopAt(stack)
		if err != nil {
			t.Fatalf("Unexpected error: %v\n", err)
		}
		actual[i] = val
	}
	expected := []int{3, 2, 6, 9, 5, 8}
	if !reflect.DeepEqual(actual, expected) {
		t.Fatalf("Expected: %v, actual: %v\n", expected, actual)
	}

	// Then push a few times to see how it handles non-full stacks.
	// It should fill up all non-empty stacks before adding stacks on the end.
	newVals := []int{11, 12, 13, 14, 15, 16, 17}
	for _, val := range newVals {
		s.Push(val)
	}
	actual = make([]int, len(vals)+1)
	for i, _ := range actual {
		val, err := s.Pop()
		if err != nil {
			t.Fatalf("Unexpected error: %v\n", err)
		}
		actual[i] = val
	}
	expected = []int{17, 16, 15, 7, 14, 13, 4, 12, 11, 1}
	if !reflect.DeepEqual(actual, expected) {
		t.Fatalf("Expected: %v, actual: %v\n", expected, actual)
	}
}
