func genKey(s string) string {
	runes := []rune(s)
	sort.Slice(runes, func(i, j int) bool {
		return runes[i] < runes[j]
	})
	return string(runes)
}

func groupAnagrams(strs []string) [][]string {
	groups := make(map[string][]string)

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
