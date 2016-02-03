package chapter3

import (
	"reflect"
	"testing"
)

func TestSortStack(t *testing.T) {
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
		s := GetSortStack()
		for _, val := range c.vals {
			s.Push(val)
		}
		actual := []int{}
		for {
			val, err := s.Pop()
			if err != nil {
				break
			} else {
				actual = append(actual, val)
			}
		}
		if !reflect.DeepEqual(c.vals, actual) {
			t.Fatalf("Expected: %d, actual: %d\n", c.vals, actual)
		}
	}

}
