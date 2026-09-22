class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var counter = new HashMap<Integer, Integer>();

        for (var num : nums)
            counter.merge(num, 1, (a, b) -> a+ b);
        
        var top = new PriorityQueue<Map.Entry<Integer, Integer>>(
            Map.Entry.<Integer, Integer>comparingByValue().reversed()
        );

        top.addAll(counter.entrySet());

        var topK = new int[k];
        for (int i = 0; i < k; i++)
            topK[i] = top.poll().getKey();

        return topK;
    }
}
