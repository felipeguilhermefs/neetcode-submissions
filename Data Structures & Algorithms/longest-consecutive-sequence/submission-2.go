func longestConsecutive(nums []int) int {
    mp := make(map[int]int)
    max := 0

    for _, num := range nums {
        if mp[num] == 0 {
            left := mp[num - 1]
            right := mp[num + 1]
            sum := left + right + 1
            mp[num] = sum
            mp[num - left] = sum 
            mp[num + right] = sum

            if sum > max {
                max = sum
            }
        }
    }

    return max
}
