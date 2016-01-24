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
