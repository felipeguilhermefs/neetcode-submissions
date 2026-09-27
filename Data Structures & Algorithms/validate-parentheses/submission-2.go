func isValid(s string) bool {
    stack := []rune{}
	clo := map[rune]rune{')': '(', ']': '[', '}': '{'}

	for _, char := range s {
		if open, exists := clo[char]; exists {
			count := len(stack)
            if count == 0 {
                return false
            }
			
            if stack[count-1] != open {
                return false
            }
            stack = stack[:count-1]
        } else {
            stack = append(stack, char)
        }
	}

	return len(stack) == 0
}
