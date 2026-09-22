class Graph {
    private record Vertex(int value, Map<Integer, Vertex> edges) {
        void addEdge(Vertex vertex) {
            edges.put(vertex.value(), vertex);
        }

        boolean removeEdge(Vertex vertex) {
            if (vertex == null || !edges.containsKey(vertex.value())) return false;

            edges.remove(vertex.value());
            return true;
        }
    }

    private final Map<Integer, Vertex> vertices = new HashMap<>();

    public Graph() {
    }

    public void addEdge(int src, int dst) {
        var srcVertex = vertices.computeIfAbsent(src, k -> new Vertex(k, new HashMap<>()));
        var dstVertex = vertices.computeIfAbsent(dst, k -> new Vertex(k, new HashMap<>()));

        srcVertex.addEdge(dstVertex);
    }

    public boolean removeEdge(int src, int dst) {
        var srcVertex = vertices.get(src);
        if (srcVertex == null) return false;

        return srcVertex.removeEdge(vertices.get(dst));

    }
    public boolean hasPath(int src, int dst) {
        var srcVertex = vertices.get(src);
        var dstVertex = vertices.get(dst);
        if (srcVertex == null || dstVertex == null) return false;

        var queue = new ArrayDeque<Vertex>();
        queue.offer(srcVertex);
        var visited = new HashSet<Integer>();
        visited.add(srcVertex.value());

        while (!queue.isEmpty()) {
            var nLevel = queue.size();
            for (int i = 0; i < nLevel; i++) {
                var vertex = queue.poll();
                if (vertex.value() == dst) return true;

                for (var next : vertex.edges().values())
                    if (visited.add(next.value))
                        queue.offer(next);
            }
        }
        return false;
    }
}
