package Accepted;

public class UniquePathII {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        return find(obstacleGrid, 0, 0, dp);
    }
    
    private int find(int[][] obstacleGrid, int x, int y, int[][] dp) {
        if (x < 0 || x >= obstacleGrid.length || y < 0 || y >= obstacleGrid[0].length)
            return 0;
        if (obstacleGrid[x][y] == 1)
            return 0;
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1)
            return 1;
        if (dp[x][y] != -1)
            return dp[x][y];
        dp[x][y] = find(obstacleGrid, x + 1, y, dp) + find(obstacleGrid, x, y + 1, dp);
        return dp[x][y];
    }
}
