func block(i, j int) int {
	b := 0
	if i >= 3 && i < 6 {
		b = 1
	} else if i >= 6 {
		b = 2
	}

	if j >= 3 && j < 6 {
		b += 3
	} else if j >= 6 {
		b += 6
	}

	return b
}

func isValidSudoku(board [][]byte) bool {
	rows := make([]map[byte]bool, 9)
	columns := make([]map[byte]bool, 9)
	blocks := make([]map[byte]bool, 9)

	for i := 0; i < 9; i++ {
		rows[i] = make(map[byte]bool)
		columns[i] = make(map[byte]bool)
		blocks[i] = make(map[byte]bool)
	}

	for i, line := range board {
		for j, cell := range line {
			if cell == '.' {
				continue
			}

			if rows[i][cell] {
				return false
			} else {
				rows[i][cell] = true
			}

			if columns[j][cell] {
				return false
			} else {
				columns[j][cell] = true
			}

			b := block(i, j)
			if blocks[b][cell] {
				return false
			} else {
				blocks[b][cell] = true
			}
		}
	}

	return true
}
