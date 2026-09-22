class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return -1;

        int kth = nums.length - k;
        return quicksearch(nums, 0, nums.length-1, kth);
    }

    private int quicksearch(int[] nums, int low, int high, int k) {
        

        int pivot = nums[high];
        int left = low;

        for (int i = low; i < high; i++) {
            if (nums[i] >= pivot) continue;
            
            int tmp = nums[left];
            nums[left] = nums[i];
            nums[i] = tmp;
            
            left++;
        }

        nums[high] = nums[left];
        nums[left] = pivot;

        if (left == k) return nums[left];

        return left > k
            ? quicksearch(nums, low, left-1, k)
            : quicksearch(nums, left+1, high, k);
    }
}
