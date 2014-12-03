package Accepted;

public class NQueensII {

	public int totalNQueens(int n) {
        if (n < 2)
            return n;
        int[] pan = new int[n];
        for (int i = 0; i < n; i++)
            pan[i] = -1;
        return totalNum(pan, 0);
    }
    
    private int totalNum(int[] pan, int row) {
        int n = pan.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int[] tmpPan = new int[n];
            System.arraycopy(pan, 0, tmpPan, 0, pan.length);
            tmpPan[row] = i;
            if (valid(tmpPan, row)) {
                if (row == n - 1)
                    result++;
                else
                    result += totalNum(tmpPan, row + 1);
            }
        }
        return result;
    }
    
    private boolean valid(int[] pan, int row) {
        for (int i = 0; i < row; i++) {
            if (pan[i] == pan[row] || Math.abs(pan[i] - pan[row]) == Math.abs(i - row))
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
    	int n = 9;
    	System.out.println(new NQueensII().totalNQueens(n));
    }
}
