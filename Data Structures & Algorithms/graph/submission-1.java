class Graph {
    private final Map<Integer, Set<Integer>> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        vertices.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
        vertices.computeIfAbsent(dst, k -> new HashSet<>());
    }

    public boolean removeEdge(int src, int dst) {
        var srcVertex = vertices.get(src);
        if (srcVertex == null) return false;
        if (!srcVertex.contains(dst)) return false;

        srcVertex.remove(dst);
        return true;

    }
    public boolean hasPath(int src, int dst) {
        var srcVertex = vertices.get(src);
        var dstVertex = vertices.get(dst);
        if (srcVertex == null || dstVertex == null) return false;

        var queue = new ArrayDeque<Integer>();
        queue.offer(src);
        var visited = new HashSet<Integer>();
        visited.add(src);

        while (!queue.isEmpty()) {
            var nLevel = queue.size();
            for (int i = 0; i < nLevel; i++) {
                var vertex = queue.poll();
                if (vertex == dst) return true;

                for (var next : vertices.get(vertex))
                    if (visited.add(next))
                        queue.offer(next);
            }
        }
        return false;
    }
}
