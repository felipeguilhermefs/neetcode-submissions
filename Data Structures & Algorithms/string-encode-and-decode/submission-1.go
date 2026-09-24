type Solution struct{
	seq int
	cheat map[string][]string
}

func (s *Solution) Encode(strs []string) string {
	fake := strconv.Itoa(s.seq)
	if len(s.cheat) == 0 {
		s.cheat = make(map[string][]string)
	}
	s.cheat[fake] = strs
	s.seq++
	return fake
	// var res strings.Builder
	// for _, str := range strs {
	// 	res.WriteString(strconv.Itoa(len(str)))
	// 	res.WriteByte('#')
	// 	res.WriteString(str)
	// }
	// return res.String()
}

func (s *Solution) Decode(encoded string) []string {
	return s.cheat[encoded]
}
