package chapter3

import (
	"reflect"
	"testing"
)

func TestSliceMultiStack(t *testing.T) {
	// Set up data.
	vals1 := []int{1, 2, 3, 4, 5}
	vals2 := []int{6, 7, 8}
	vals3 := []int{9, 10}
	expected := []int{1, 2, 3, 4, 5, 0, 6, 7, 8,
		0, 0, 0, 9, 10, 0, 0, 0, 0}
	s := GetSliceMultiStack(3, 6)
	// Test push.
	for _, val := range vals1 {
		s.Push(1, val)
	}
	for _, val := range vals2 {
		s.Push(2, val)
	}
	for _, val := range vals3 {
		s.Push(3, val)
	}
	actual := []int{}
	for _, val := range s.slice {
		if val != nil {
			actual = append(actual, val.value)
		} else {
			actual = append(actual, 0)
		}
	}
	if !reflect.DeepEqual(actual, expected) {
		t.Fatalf("Expected: %v, actual: %v\n", expected, actual)
	}
	// Test pop.
	var err error
	pop1, err := s.Pop(1)
	if err != nil {
		t.Fatalf("Unexpected error: %v\n", err)
	}
	pop2, err := s.Pop(1)
	if err != nil {
		t.Fatalf("Unexpected error: %v\n", err)
	}
	pop3, err := s.Pop(3)
	if err != nil {
		t.Fatalf("Unexpected error: %v\n", err)
	}
	expected = []int{1, 2, 3, 0, 0, 0, 6, 7, 8,
		0, 0, 0, 9, 0, 0, 0, 0, 0}
	actual = []int{}
	for _, val := range s.slice {
		if val != nil {
			actual = append(actual, val.value)
		} else {
			actual = append(actual, 0)
		}
	}
	if !reflect.DeepEqual(actual, expected) {
		t.Fatalf("Expected: %v, actual: %v\n", expected, actual)
	}
	pops := []int{pop1, pop2, pop3}
	expected = []int{5, 4, 10}
	if !reflect.DeepEqual(pops, expected) {
		t.Fatalf("Expected: %v, actual: %v\n", expected, actual)
	}
}
