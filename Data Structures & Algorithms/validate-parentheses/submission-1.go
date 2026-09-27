type stack struct{
	items []rune
}

func (s *stack) Push(v rune) {
    s.items = append(s.items, v)
}

func (s *stack) Pop() (rune, bool) {
	count := len(s.items)
	if count == 0 {
		return -1, false
	}

	res := s.items[count-1]
	s.items = s.items[:count-1]

	return res, true
}

func isValid(s string) bool {
    op := stack{[]rune{}}
	clo := make(map[rune]rune)
	clo[')'] = '('
	clo[']'] = '['
	clo['}'] = '{'

	for _, char := range s {
		if char == '(' || char == '{' || char == '[' {
			op.Push(char)
			continue
		} else {
			item, ok := op.Pop()
			if !ok {
				return false
			}

			if clo[char] != item {
				return false
			} 
		}
	}

	if _, ok := op.Pop(); ok {
		return false
	}
	return true
}
