public class Solution {
    public int countIslands(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int validIslandCount = 0;
        
        // Iterate through every cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If a cell has a positive value, it's an unvisited island part
                if (grid[i][j] > 0) {
                    long totalValue = dfs(grid, i, j, m, n);
                    // Check if the cumulative value of the island is divisible by k
                    if (totalValue % k == 0) {
                        validIslandCount++;
                    }
                }
            }
        }
        
        return validIslandCount;
    }
    
    private long dfs(int[][] grid, int r, int c, int m, int n) {
        // Base case: check boundary and if it's water/visited (<= 0)
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] <= 0) {
            return 0;
        }
        
        // Grab current value and sink the cell to mark it visited
        long currentVal = grid[r][c];
        grid[r][c] = 0; 
        
        // 4-directional flood fill exploration
        long islandSum = currentVal;
        islandSum += dfs(grid, r - 1, c, m, n); // Up
        islandSum += dfs(grid, r + 1, c, m, n); // Down
        islandSum += dfs(grid, r, c - 1, m, n); // Left
        islandSum += dfs(grid, r, c + 1, m, n); // Right
        
        return islandSum;
    }
}