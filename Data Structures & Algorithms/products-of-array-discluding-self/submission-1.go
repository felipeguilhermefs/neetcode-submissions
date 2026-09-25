func productExceptSelf(nums []int) []int {
	product := 1
	countZeroes, indexZero := 0, -1
	for i, num := range nums {
		if num != 0 {
			product *= num
		} else {
			countZeroes++
			indexZero = i
		}
	}

	output := make([]int, len(nums))

	if countZeroes > 1 {
		return output
	}

	if countZeroes == 1 {
		output[indexZero] = product
		return output
	}

	for i, num := range nums {
		if num == 0 {
			output[i] = product
		} else {
			output[i] = product / num
		}
	}

	return output
}
