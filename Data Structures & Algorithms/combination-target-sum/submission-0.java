class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        var res = new ArrayList<List<Integer>>();

        backtracking(nums, res, new ArrayList<>(), 0, target);

        return res;
    }

    private void backtracking(int[] nums, List<List<Integer>> res, List<Integer> comb, int index, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        if (target < 0) return;

        for(int i=index; i<nums.length; i++) {
            comb.add(nums[i]);
            backtracking(nums, res, comb, i, target-nums[i]);
            comb.remove(comb.size()-1);
        }
    }
}
