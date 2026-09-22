func isAnagram(s string, t string) bool {
	letters := make([]int, 26)
	for _, letter := range s {
		letters[letter - 'a'] += 1 
	}

	for _, letter := range t {
		letters[letter - 'a'] -= 1
		if letters[letter - 'a'] < 0 {
			return false
		}
	}

	for _, count := range letters {
		if count > 0 {
			return false
		}
	}

	return true
}
