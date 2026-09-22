func genKey(s string) [26]int {
	count := [26]int{}
	for _, letter := range s {
		count[letter - 'a']++
	}
	return count
}

func groupAnagrams(strs []string) [][]string {
	groups := make(map[[26]int][]string)

	for _, str := range strs {
		group := genKey(str)
		groups[group] = append(groups[group], str)

	}

	res := [][]string{}
	for _, group := range groups {
		res = append(res, group)
	}

	return res
}
