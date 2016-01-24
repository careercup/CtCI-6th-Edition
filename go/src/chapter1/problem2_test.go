package chapter1

import (
	"testing"
)

func TestArePermutations(t *testing.T) {
	if ArePermutations("abcd", "abdc") != true {
		t.Fatalf("Should be true, was false.")
	}
	if ArePermutations("abcc", "ccbb") != false {
		t.Fatalf("Should be false, was true.")
	}
}
