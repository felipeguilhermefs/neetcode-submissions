class Solution {
    public int shortestPath(int[][] grid) {
        var nRows = grid.length;
        var nCols = grid[0].length;
        if (nRows == 0 || nCols == 0) return -1;

        var visited = new HashSet<Tuple>();
        var nodes = new ArrayDeque<Tuple>();

        visited.add(new Tuple(0, 0));
        nodes.addLast(new Tuple(0, 0));

        int length = 0;
        var dirs = List.of(
            new Tuple(0, 1),
            new Tuple(1, 0),
            new Tuple(0,-1),
            new Tuple(-1, 0)
        );
        while(!nodes.isEmpty()) {
            var nNodes = nodes.size();
            for (int i = 0; i < nNodes; i++) {
                var node = nodes.pollFirst();
                if (node.row() == nRows-1 && node.col() == nCols-1) return length;

                for (var dir : dirs) {
                    var row = node.row() + dir.row();
                    var col = node.col() + dir.col();

                    if (row < 0 || col < 0) continue;
                    if (row == nRows || col == nCols) continue;
                    if (grid[row][col] == 1) continue;
                
                    var newNode = new Tuple(row, col);
                    if (visited.add(newNode)) {
                        nodes.addLast(newNode);
                    }
                }
            }
            length++;
        }
        return -1;
    }

    private String node(int row, int col) {
        return "%s:%s".formatted(row, col);
    }

    record Tuple(int row, int col) {}
}
