func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	letters := [26]int{}
	for i := 0; i < len(s); i++ {
		letters[s[i] - 'a']++
		letters[t[i] - 'a']-- 
	}

	for _, count := range letters {
		if count != 0 {
			return false
		}
	}

	return true
}
