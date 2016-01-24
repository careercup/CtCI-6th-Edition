package chapter1

import (
	"testing"
)

func TestURLify(t *testing.T) {
	expected := "hello%20my%20name%20is"
	actual := URLify("hello my name is")
	if expected != actual {
		t.Fatalf("Output didn't match. Expected %s, actual %s\n", expected, actual)
	}
}
