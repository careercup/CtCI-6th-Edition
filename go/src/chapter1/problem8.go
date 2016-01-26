package chapter1

func ZeroRow(matrix [][]int, row int) {
	for i := 0; i < len(matrix[0]); i++ {
		matrix[row][i] = 0
	}
}

func ZeroColumn(matrix [][]int, col int) {
	for i := 0; i < len(matrix); i++ {
		matrix[i][col] = 0
	}
}

func ZeroMatrix(matrix [][]int) {
	rows := make([]bool, len(matrix))
	cols := make([]bool, len(matrix[0]))
	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {
			if matrix[i][j] == 0 {
				rows[i] = true
				cols[j] = true
			}
		}
	}
	for r := 0; r < len(rows); r++ {
		if rows[r] {
			ZeroRow(matrix, r)
		}
	}
	for c := 0; c < len(cols); c++ {
		if cols[c] {
			ZeroColumn(matrix, c)
		}
	}
}
