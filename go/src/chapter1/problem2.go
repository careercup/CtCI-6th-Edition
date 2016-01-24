package chapter1

func ArePermutations(input1, input2 string) bool {
	if len(input1) != len(input2) {
		return false
	}
	counts := make(map[rune]int)
	for _, r := range input1 {
		counts[r]++
	}
	for _, r := range input2 {
		counts[r]--
	}
	for _, val := range counts {
		if val != 0 {
			return false
		}
	}
	return true
}
