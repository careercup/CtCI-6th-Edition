package chapter1

import (
	"testing"
)

func TestIsPalindromePerm(t *testing.T) {
	cases := []struct {
		input    string
		expected bool
	}{
		{"amanaplanacanalpanama", true},   // normal palindrome
		{"amanalpancaaanplanama", true},   // jumbled palindrome
		{"amanaplanacanalpanamab", false}, // not a palindrome
		{"a", true},
		{"", true},
	}
	for _, c := range cases {
		actual := IsPalindromePerm(c.input)
		if actual != c.expected {
			t.Fatalf("Input %s. Expected: %b, actual: %b\n", c.input, c.expected, actual)
		}
	}
}
