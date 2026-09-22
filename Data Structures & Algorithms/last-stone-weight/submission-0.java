class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];

        var weights = new PriorityQueue<Integer>(stones.length, Comparator.reverseOrder());
        for (var stone : stones) weights.add(stone);

        while (weights.size() > 1) {
            var w1 = weights.poll();
            var w2 = weights.poll();
            
            var diff = Math.abs(w1 - w2);
            if (diff != 0) weights.add(diff);
        }

        var last = weights.poll();
        return last != null ? last : 0;
    }
}
