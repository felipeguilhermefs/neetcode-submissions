class Solution {
    public int orangesRotting(int[][] grid) {
        var nRows = grid.length;
        var nCols = grid[0].length;
        var q = new ArrayDeque<int[]>();
        var fresh = 0;
        var time = 0;

        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                if (grid[row][col] == 1) fresh++;
                if (grid[row][col] == 2) q.offer(new int[]{row, col});
            }
        }

        var directions = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        while (fresh > 0 && !q.isEmpty()) {
            var length = q.size();
            for (int i = 0; i<length; i++) {
                var node = q.poll();
                for (var dir: directions) {
                    var row = node[0] + dir[0];
                    var col = node[1] + dir[1];

                    if (row < 0 || col < 0) continue;
                    if (row == nRows || col == nCols) continue;

                    if (grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
