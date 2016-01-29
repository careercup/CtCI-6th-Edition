package chapter2

import (
	"testing"
)

func TestKFromTail(t *testing.T) {
	vals := []int{1, 1, 1, 2, 3, 3, 4, 5, 5, 6}
	ll := GetLinkedListFromValues(vals)
	actual := ll.KFromTail(3)
	expected := 4
	if expected != actual {
		t.Fatalf("Expected: %v, actual: %v\n", expected, actual)
	}
	actual = ll.KFromTail(0)
	expected = 6
	if expected != actual {
		t.Fatalf("Expected: %v, actual: %v\n", expected, actual)
	}
}

func TestKFromTail2(t *testing.T) {
	vals := []int{1, 1, 1, 2, 3, 3, 4, 5, 5, 6}
	ll := GetLinkedListFromValues(vals)
	actual := ll.KFromTail2(3)
	expected := 4
	if expected != actual {
		t.Fatalf("Expected: %v, actual: %v\n", expected, actual)
	}
	actual = ll.KFromTail2(0)
	expected = 6
	if expected != actual {
		t.Fatalf("Expected: %v, actual: %v\n", expected, actual)
	}
}
