package chapter1

func IsPalindromePerm(input string) bool {
	counts := make(map[rune]int)
	inputLen := 0
	for _, r := range input {
		counts[r]++
		inputLen++
	}
	odd := inputLen%2 == 1
	seenOdd := false
	for _, val := range counts {
		if val%2 == 1 {
			if !seenOdd && odd {
				seenOdd = true
			} else {
				return false
			}
		}
	}
	return true
}
