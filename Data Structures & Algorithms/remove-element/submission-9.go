func removeElement(nums []int, val int) int {
	pivot := len(nums) - 1

	if pivot < 0 {
		return 0
	}

	
		for nums[pivot] == val && pivot > 0 {
			pivot--
		}
if pivot == 0 {
		if nums[pivot] == val {
			return 0
		}
		return 1
	}
	for i := 0; i <= pivot; i++ {
		if nums[i] == val {
			nums[i], nums[pivot] = nums[pivot], nums[i]
			pivot--
		}
		for nums[pivot] == val && pivot > 0 {
			pivot--
		}
	} 

	return pivot +1
}
