class Solution {
    public int longestConsecutive(int[] nums) {
        var lookup = new HashSet<Integer>();
        for (var num : nums)
            lookup.add(num);

        var longest = 0;
        for (var num : lookup) {
            if (lookup.contains(num-1)) continue;

            int length = 1;
            while (lookup.contains(num + length))
                length++;

            longest = Math.max(length, longest);
        }
        return longest;
    }
}
