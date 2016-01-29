package chapter2

import (
	"testing"
)

func TestIsPalindrome(t *testing.T) {
	cases := []struct {
		vals     []int
		expected bool
	}{
		{
			[]int{7, 1, 6},
			false,
		},
		{
			[]int{7, 1, 7},
			true,
		},
		{
			[]int{7, 1, 1, 7},
			true,
		},
		{
			[]int{},
			true,
		},
		{
			[]int{7},
			true,
		},
		{
			[]int{7, 7},
			true,
		},
	}
	for _, c := range cases {
		ll := GetLinkedListFromValues(c.vals)
		actual := ll.IsPalindrome()
		if c.expected != actual {
			t.Fatalf("Expected: %v, actual: %v\n", c.expected, actual)
		}
	}
}
