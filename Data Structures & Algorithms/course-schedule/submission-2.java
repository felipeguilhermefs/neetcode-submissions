class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var graph = new HashMap<Integer, Set<Integer>>();

        for (int i = 0; i < numCourses; i ++)
            graph.put(i, new HashSet<>());

        for (var pair : prerequisites)
            graph.get(pair[0]).add(pair[1]);

        var visited = new HashSet<Integer>();
        for (int c = 0; c < numCourses; c++)
            if (!dfs(c, graph, visited))
                return false;

        return true;
    }

    private boolean dfs(int course, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(course)) return false;
        if (graph.get(course).isEmpty()) return true;

        visited.add(course);
        for (var prereq : graph.get(course))
            if (!dfs(prereq, graph, visited))
                return false;
        visited.remove(course);

        graph.put(course, new HashSet<>());
        return true;
    }
}
