package chapter3

import (
	"testing"
)

func TestMinStack(t *testing.T) {
	cases := []struct {
		vals     []int
		expected int
	}{
		{
			[]int{1, 2, 3, 4, 5},
			1,
		},
		{
			[]int{1},
			1,
		},
		{
			[]int{5, 4, 3, 2, 1},
			1,
		},
	}
	for _, c := range cases {
		s := GetMinStack()
		for _, val := range c.vals {
			s.Push(val)
		}
		actual, err := s.Min()
		if err != nil {
			t.Fatalf("Unexpected error: %v\n", err)
		}
		if actual != c.expected {
			t.Fatalf("Expected: %d, actual: %d\n", c.expected, actual)
		}
	}

}
