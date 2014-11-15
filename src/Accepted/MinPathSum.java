package Accepted;

public class MinPathSum {

	int[][] dp;
    
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        return minPathSum(grid, 0, 0);
    }
    
    private int minPathSum(int[][] grid, int x, int y) {
        if (x == grid.length - 1 && y == grid[0].length - 1)
            return grid[x][y];
        if (dp[x][y] != -1)
            return dp[x][y];
        int result = Integer.MAX_VALUE;
        if (x < grid.length - 1)
            result = Math.min(result, minPathSum(grid, x + 1, y) + grid[x][y]);
        if (y < grid[0].length - 1)
            result = Math.min(result, minPathSum(grid, x, y + 1) + grid[x][y]);
        dp[x][y] = result;
        return result;
    }
}
