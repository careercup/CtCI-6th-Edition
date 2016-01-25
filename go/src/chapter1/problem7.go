package chapter1

func MatrixRotate(matrix [][]int) {
	n := len(matrix)
	for layer := 0; layer < n/2; layer++ {
		last := n - 1 - layer
		for i := layer; i < last; i++ {
			offset := i - layer
			temp := matrix[layer][i]
			matrix[layer][i] = matrix[last-offset][layer]
			matrix[last-offset][layer] = matrix[last][last-offset]
			matrix[last][last-offset] = matrix[i][last]
			matrix[i][last] = temp
		}
	}
}
