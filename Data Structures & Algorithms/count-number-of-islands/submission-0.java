class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                
                if (grid[row][col] == '1') {
                   dfs(grid, row, col);
                   count++; 
                }

            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0) return;
        if (row >= grid.length || col >= grid[row].length) return;
        if (grid[row][col] == '0') return;

        grid[row][col] = '0';
        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
    }
}
