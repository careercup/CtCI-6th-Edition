package chapter3

import (
	"reflect"
	"testing"
)

func TestQueue(t *testing.T) {
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
		s := &Queue{}
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
