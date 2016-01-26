package chapter1

import (
	"testing"
)

func TestIsRotation(t *testing.T) {
	cases := []struct {
		input1   string
		input2   string
		expected bool
	}{
		{"waterbottle", "terbottlewa", true},
		{"hellomynameis", "nameishellomy", true},
		{"waterbottle", "water", false},
		{"waterbottle", "elttobretaw", false},
		{" ", " ", true},
		{"", "", true},
	}
	for _, c := range cases {
		actual := IsRotation(c.input1, c.input2)
		if actual != c.expected {
			t.Fatalf("Inputs %s, %s. Expected: %b, actual: %b\n",
				c.input1, c.input2, c.expected, actual)
		}
	}
}
