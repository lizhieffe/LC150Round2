package Accepted;

public class InterleavingString {

	int[][] dp;
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        if (s1.length() + s2.length() != s3.length())
            return false;
        if (s3.length() == 0)
            return true;
            
        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i ++)
            for (int j = 0; j < s2.length(); j ++)
                dp[i][j] = -1;
        return isInterleave(s1, 0, s2, 0, s3) == 1 ? true : false;
    }
    
    private int isInterleave(String s1, int i1, String s2, int i2, String s3) {
        if (i1 >= s1.length() && i2 >= s2.length())
            return 1;
        if (i1 >= s1.length())
            return s2.charAt(i2) == s3.charAt(i1 + i2) ? isInterleave(s1, i1, s2, i2 + 1, s3) : 0;
        if (i2 >= s2.length())
            return s1.charAt(i1) == s3.charAt(i1 + i2) ? isInterleave(s1, i1 + 1, s2, i2, s3) : 0;
        if (dp[i1][i2] != -1)
            return dp[i1][i2];
        int result = 0;
        if (s1.charAt(i1) == s3.charAt(i1 + i2))
            result = isInterleave(s1, i1 + 1, s2, i2, s3);
        if (result != 1 && s2.charAt(i2) == s3.charAt(i1 + i2))
            result = isInterleave(s1, i1, s2, i2 + 1, s3);
        dp[i1][i2] = result;
        return result;
    }
}
