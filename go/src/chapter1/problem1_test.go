package chapter1

import (
	"testing"
)

func TestIsUnique(t *testing.T) {
	if IsUnique("abcd") != true {
		t.Fatalf("Should be true, was false.")
	}
	if IsUnique("abcc") != false {
		t.Fatalf("Should be false, was true.")
	}
}
