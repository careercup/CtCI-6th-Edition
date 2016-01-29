package chapter3

import (
	"reflect"
	"sort"
	"testing"
)

type intSlice []int

func (s intSlice) Len() int           { return len(s) }
func (s intSlice) Swap(i, j int)      { s[i], s[j] = s[j], s[i] }
func (s intSlice) Less(i, j int) bool { return s[i] < s[j] }

func TestStack(t *testing.T) {
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
		s := &Stack{}
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
		sort.Sort(sort.Reverse(intSlice(c.vals)))
		if !reflect.DeepEqual(c.vals, actual) {
			t.Fatalf("Expected: %d, actual: %d\n", c.vals, actual)
		}
	}

}
