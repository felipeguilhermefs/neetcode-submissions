func isValidSudoku(board [][]byte) bool {
	rows := make([]int, 9)
	columns := make([]int, 9)
	blocks := make([]int, 9)

	for i, line := range board {
		for j, cell := range line {
			if cell == '.' {
				continue
			}

			bit := 1 << (cell - '1')
			block := (i/3)*3 + j/3

			if rows[i]&bit != 0 || columns[j]&bit != 0 || blocks[block]&bit != 0 {
				return false
			}
			
			rows[i] |= bit
			columns[j] |= bit
			blocks[block] |= bit
		}
	}

	return true
}
