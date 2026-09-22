class Solution {
    public boolean hasDuplicate(int[] nums) {
        var distincts = new HashSet<Integer>();
        for (int num : nums) {
            if (distincts.contains(num)) return true;
            distincts.add(num);
        }
        return false;
    }
}
