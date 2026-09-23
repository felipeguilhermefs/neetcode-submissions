func removeElement(nums []int, val int) int {
	k, i := len(nums), 0

	for i < k {
		if nums[i] == val {
			k--
			nums[i] = nums[k]
		} else {
			i++
		}
	}
	return k
}
