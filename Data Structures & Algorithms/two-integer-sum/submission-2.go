func twoSum(nums []int, target int) []int {
    sums := make(map[int]int)

    for i, num := range nums {
        if j, ok := sums[num]; ok {
            return []int{j, i}
        }
        sums[target - num] = i
    } 
    return []int{}
}
