package chapter1

import (
	"strings"
)

func IsRotation(input1, input2 string) bool {
	if len(input1) != len(input2) {
		return false
	}
	newStr := input2 + input2
	return strings.Contains(newStr, input1)
}
