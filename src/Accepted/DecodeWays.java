package Accepted;

public class DecodeWays {

	public class Solution {
	    
	    int[] dp;
	    
	    public int numDecodings(String s) {
	        if (s == null || s.length() == 0)
	            return 0;
	        dp = new int[s.length()];
	        for (int i = 0; i < s.length(); i++)
	            dp[i] = -1;
	        return numDecodings(s, 0);
	    }
	    
	    private int numDecodings(String s, int beg) {
	        if (beg == s.length() - 1)
	            return s.charAt(beg) == '0' ? 0 : 1;
	        if (beg > s.length() - 1)
	            return 1;
	        if (dp[beg] != -1)
	            return dp[beg];
	        int result = 0;
	        if (s.charAt(beg) > '0')
	            result += numDecodings(s, beg + 1);
	        int twoDigits = Integer.parseInt(s.substring(beg, beg + 2));
	        if (twoDigits > 0 && twoDigits < 27 && s.charAt(beg) != '0')
	            result += numDecodings(s, beg + 2);
	        dp[beg] = result;
	        return result;
	    }
	}
}
