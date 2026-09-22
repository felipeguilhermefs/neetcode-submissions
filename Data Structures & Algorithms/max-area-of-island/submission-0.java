class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                
                if (grid[row][col] == 1) {
                   int size = dfs(grid, row, col);
                   if (size > max) max = size; 
                }

            }
        }
        return max;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0) return 0;
        if (row >= grid.length || col >= grid[row].length) return 0;
        if (grid[row][col] == 0) return 0;

        grid[row][col] = 0;
        int size = 1;
        size += dfs(grid, row+1, col);
        size += dfs(grid, row-1, col);
        size += dfs(grid, row, col+1);
        size += dfs(grid, row, col-1);
        return size;
    }
}
