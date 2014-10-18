package Accepted;

public class DistinctSubsequences {

int[][] dp;
    
    public int numDistinct(String S, String T) {
        if (S == null || T == null || S.length() == 0 || T.length() == 0)
            return 0;
        
        dp = new int[S.length()][T.length()];
        for (int i = 0; i < S.length(); i ++)
            for (int j = 0; j < T.length(); j ++)
                dp[i][j] = -1;
        return findNumDistinct(S, 0, T, 0);
    }

    private int findNumDistinct(String S, int beg1, String T, int beg2) {
        if (beg2 == T.length())
            return 1;
        if (beg1 == S.length())
            return 0;
        if (dp[beg1][beg2] != -1)
            return dp[beg1][beg2];
        int result = 0;
        for (int i = beg1; i < S.length() - (T.length() - beg2) + 1; i ++) {
            if (S.charAt(i) == T.charAt(beg2)) {
            	result += findNumDistinct(S, i + 1, T, beg2 + 1);
            }
        }
        dp[beg1][beg2] = result;
        return result;
    }
    
    public static void main(String[] args) {
    	String S = "aabb";
    	String T = "ab";
    	System.out.println(new DistinctSubsequences().numDistinct(S, T));
    }
}
