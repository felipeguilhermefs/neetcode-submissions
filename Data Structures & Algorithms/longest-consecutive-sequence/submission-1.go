func longestConsecutive(nums []int) int {
    all := make(map[int]bool)

    for _, num := range nums {
        all[num] = true
    }

    max := 0
    for _, num := range nums {
        if !all[num-1] {
            count := 1
            for all[num+1] {
                count++
                num++
            }

            if count > max {
                max = count
            }
        }
    }

    return max
}
