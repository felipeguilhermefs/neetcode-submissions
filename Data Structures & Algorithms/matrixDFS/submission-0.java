class Solution {
    public int countPaths(int[][] grid) {
        return dfs(grid, 0, 0, new HashSet<>());
    }

    private int dfs(int[][]grid, int row, int col, Set<String> visited) {
        if (row < 0 || col < 0) return 0;
        if (row == grid.length || col == grid[0].length) return 0;
        if (grid[row][col] == 1) return 0;
        if (visited.contains(row + "," + col)) return 0; 
        
        if (row == grid.length-1 && col == grid[0].length-1) return 1;

        visited.add(row + "," + col);

        int count = 0;

        count += dfs(grid, row, col-1, visited);
        count += dfs(grid, row, col+1, visited);
        count += dfs(grid, row-1, col, visited);
        count += dfs(grid, row+1, col, visited);

        visited.remove(row + "," + col);

        return count;
    }
}
