package Accepted;

public class EditDistance {

	int[][] dp;
    
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null)
            return -1;
        if (word1.length() == 0)
            return word2.length();
        if (word1.equals(word2))
            return 0;
        
        dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i ++)
            for (int j = 0; j < word2.length(); j ++)
                dp[i][j] = -1;
        return minDistance(word1, 0, word2, 0);
    }
    
    private int minDistance(String s1, int i1, String s2, int i2) {
        if (i2 == s2.length())
            return s1.length() - i1;
        if (i1 == s1.length())
            return s2.length() - i2;
        if (dp[i1][i2] != -1)
            return dp[i1][i2];
        int result;
        if (s1.charAt(i1) == s2.charAt(i2))
            result = minDistance(s1, i1 + 1, s2, i2 + 1);
        else {
            result = 1 + Math.min(minDistance(s1, i1 + 1, s2, i2 + 1), Math.min(minDistance(s1, i1 + 1, s2, i2), minDistance(s1, i1, s2, i2 + 1)));
        } 
        dp[i1][i2] = result;
        return result;
    }
}

