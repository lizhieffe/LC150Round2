package Accepted;

public class ParlindromePartitionII {

	private int[] dpMinCut;
    private int[][] dpIsPalindrome;
    
    public int minCut(String s) {
        if (s == null || s.length() <= 1)
            return 0;
        char[] c = s.toCharArray();
        dpMinCut = new int[c.length];
        for (int i = 0; i < dpMinCut.length; ++i)
            dpMinCut[i] = -1;
        dpIsPalindrome = new int[c.length][c.length];
        for (int i = 0; i < c.length; ++i)
            for (int j = 0; j < c.length; ++j)
                dpIsPalindrome[i][j] = -1;
        return minCut(c, 0);
    }
    
    private int minCut(char[] c, int beg) {
        if (beg >= c.length)
            return 0;
        if (dpMinCut[beg] != -1)
            return dpMinCut[beg];
        int result = Integer.MAX_VALUE;
        if (isPalindrome(c, beg, c.length - 1))
            result = 0;
        else {
            for (int i = c.length - 2; i >= beg; --i) {
                if (isPalindrome(c, beg, i)) {
                    int tmp = minCut(c, i + 1);
                    if (tmp + 1 < result)
                        result = tmp + 1;
                }
            }
        }
        dpMinCut[beg] = result;
        return result;
    }
    
    private boolean isPalindrome(char[] c, int beg, int end) {
        if (beg >= end)
            return true;
        if (dpIsPalindrome[beg][end] != -1)
            return dpIsPalindrome[beg][end] == 0 ? false : true;
        boolean result;
        if (c[beg] != c[end])
            result = false;
        else
            result = isPalindrome(c, beg + 1, end - 1);
        dpIsPalindrome[beg][end] = (result == true) ? 1 : 0;
        return result;
    }
}
