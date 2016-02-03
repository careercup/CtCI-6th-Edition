package chapter3

import (
	"reflect"
	"testing"
)

func TestQueueUsingStacks(t *testing.T) {
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
		s := GetQueueUsingStacks()
		for _, val := range c.vals {
			s.Add(val)
		}
		actual := []int{}
		for {
			val, err := s.Remove()
			if err != nil {
				break
			} else {
				actual = append(actual, val)
			}
		}
		if !reflect.DeepEqual(c.vals, actual) {
			t.Fatalf("Expected: %v, actual: %v\n", c.vals, actual)
		}
	}
}

func TestQueueUsingStacksMultiPart(t *testing.T) {
	s := GetQueueUsingStacks()
	// Push 1,2,3
	for _, val := range []int{1, 2, 3} {
		s.Add(val)
	}
	// Pop 1,2
	actual := []int{}
	val, _ := s.Remove()
	actual = append(actual, val)
	val, _ = s.Remove()
	actual = append(actual, val)
	// Add 4
	s.Add(4)
	// Pop should still give 3 then 4
	val, _ = s.Remove()
	actual = append(actual, val)
	val, _ = s.Remove()
	actual = append(actual, val)

	expected := []int{1, 2, 3, 4}
	if !reflect.DeepEqual(expected, actual) {
		t.Fatalf("Expected: %v, actual: %v\n", expected, actual)
	}
}
