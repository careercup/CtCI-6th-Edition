package chapter1

// O(n) time with O(n) extra space.
func URLify(input string) string {
	spaces := 0
	count := 0
	for _, r := range input {
		count++
		if r == rune(' ') {
			spaces++
		}
	}
	// +2 for each space for the extra "20"s.
	temp := make([]rune, count+(2*spaces))
	i := 0
	for _, r := range input {
		if r == rune(' ') {
			temp[i] = rune('%')
			temp[i+1] = rune('2')
			temp[i+2] = rune('0')
			i += 3
		} else {
			temp[i] = r
			i++
		}
	}
	return string(temp)
}

// Less "real world" version taking a []rune with spaces
// on the end to be able to URLify in place.
// O(n), in place.
func URLifySlice(input []rune) {
	inWord := false
	slowPtr := len(input) - 1
	for i := len(input) - 1; i >= 0; i-- {
		if input[i] == rune(' ') {
			if inWord {
				input[slowPtr-2] = rune('%')
				input[slowPtr-1] = rune('2')
				input[slowPtr] = rune('0')
				slowPtr -= 3
			}
		} else {
			if !inWord {
				inWord = true
			}
			input[slowPtr] = input[i]
			slowPtr--
		}
	}
}
