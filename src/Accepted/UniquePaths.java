package Accepted;

public class UniquePaths {

	int[][] dp;
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0)
            return 0;
        dp = new int[m][n];
        for (int i = 0; i < m; i ++)
            for (int j = 0; j < n; j ++)
                dp[i][j] = -1;
        return uniquePaths(m, n, 0, 0);
    }
    
    private int uniquePaths(int m, int n, int i, int j) {
        if (i == m - 1 || j == n - 1)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        int result = uniquePaths(m, n, i + 1, j) + uniquePaths(m, n, i, j + 1);
        dp[i][j] = result;
        return result;
    }
}
