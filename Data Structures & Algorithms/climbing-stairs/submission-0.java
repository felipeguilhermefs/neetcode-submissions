class Solution {
    public int climbStairs(int n) {
        return fib(n, new HashMap<>());
    }

    private int fib(int n, Map<Integer, Integer> cache) {
        if (n <= 1) return 1;
        if (cache.containsKey(n)) return cache.get(n);

        var res = fib(n-1, cache) + fib(n-2, cache);
        cache.put(n, res);
        return res;
    }
}
