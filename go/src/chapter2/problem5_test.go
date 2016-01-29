package chapter2

import (
	"testing"
)

func TestAddTwoLists(t *testing.T) {
	cases := []struct {
		vals1, vals2 []int
		expected     int
	}{
		{
			[]int{7, 1, 6},
			[]int{5, 9, 2},
			912,
		},
		{
			[]int{7, 1, 6},
			[]int{2, 4},
			659,
		},
		{
			[]int{2, 4},
			[]int{7, 1, 6},
			659,
		},
		{
			[]int{},
			[]int{7, 1, 6},
			617,
		},
		{
			[]int{7, 1, 6},
			[]int{},
			617,
		},
	}
	for _, c := range cases {
		l1 := GetLinkedListFromValues(c.vals1)
		l2 := GetLinkedListFromValues(c.vals2)
		actual := AddTwoLists(l1, l2)
		if c.expected != actual {
			t.Fatalf("Expected: %v, actual: %v\n", c.expected, actual)
		}
	}
}
