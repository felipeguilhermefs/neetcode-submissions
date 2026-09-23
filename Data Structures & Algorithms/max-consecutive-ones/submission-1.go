func findMaxConsecutiveOnes(nums []int) int {
	max, count := 0, 0
	for _, num := range nums {
		if num == 1 {
			count++
		} else {
			if count > max {
				max = count
			}
			count = 0
		}
	}
	
	if count > max {
		return count
	}
	return max
}
