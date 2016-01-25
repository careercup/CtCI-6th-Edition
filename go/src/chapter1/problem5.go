package chapter1

import (
	"unicode/utf8"
)

func oneRemovalAway(smaller, larger string) bool {
	len1 := utf8.RuneCountInString(smaller)
	len2 := utf8.RuneCountInString(larger)
	var width1, width2 int
	var r1, r2 rune
	removalSeen := false
	for i, j := 0, 0; i < len1 || j < len2; i, j = i+width1, j+width2 {
		r1, width1 = utf8.DecodeRuneInString(smaller[i:])
		r2, width2 = utf8.DecodeRuneInString(larger[j:])
		if r1 != r2 {
			if removalSeen {
				return false
			} else {
				width1 = 0
				removalSeen = true
			}
		}
	}
	return true
}

func AreOneEditAway(input1, input2 string) bool {
	len1 := utf8.RuneCountInString(input1)
	len2 := utf8.RuneCountInString(input2)
	if len1 != len2 && len1-1 != len2 && len2-1 != len1 {
		return false
	}
	if len1 == len2 { // must be one replacement
		var width1, width2 int
		var r1, r2 rune
		diffSeen := false
		for i, j := 0, 0; i < len1 || j < len2; i, j = i+width1, j+width2 {
			r1, width1 = utf8.DecodeRuneInString(input1[i:])
			r2, width2 = utf8.DecodeRuneInString(input2[j:])
			if r1 != r2 {
				if diffSeen {
					return false
				} else {
					diffSeen = true
				}
			}
		}
		return true
	} else if len1-1 == len2 { // input1 must be a removal from input2
		return oneRemovalAway(input2, input1)
	} else { //if len2-1 == len1 { // input2 must be a removal from input1
		return oneRemovalAway(input1, input2)
	}
}
