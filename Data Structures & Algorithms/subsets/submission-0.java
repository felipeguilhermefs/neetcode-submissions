class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        var res = new ArrayList<List<Integer>>();

        dfs(res, new ArrayList<Integer>(), nums, 0);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> subset, int[] nums, int index) {
        if (index>=nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(res, subset, nums, index+1);

        subset.remove(subset.size()-1);
        dfs(res, subset, nums, index+1);
    }
}
