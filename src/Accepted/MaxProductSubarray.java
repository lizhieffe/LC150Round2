package Accepted;

public class MaxProductSubarray {

	public int maxProduct(int[] A) {
        if (A.length == 0)
            return 0;
        if (A.length == 1)
            return A[0];
        return maxProduct(A, 0, A.length - 1);
    }
    
    private int maxProduct(int[] A, int beg, int end) {
        if (beg == end)
            return A[beg];
        if (beg > end || beg >= A.length || end < 0)
            return Integer.MIN_VALUE;
        int product = 1;
        int idFirstNeg = -1;
        int idLastNeg = -1;
        for (int i = beg; i <= end; i++) {
            if (A[i] == 0) {
                return Math.max(0, Math.max(maxProduct(A, beg, i - 1), maxProduct(A, i + 1, end)));
            }
            product *= A[i];
            if (A[i] < 0) {
                if (idFirstNeg == -1)
                    idFirstNeg = i;
                idLastNeg = i;
            }
        }
        if (product > 0)
            return product;
        else
            return Math.max(maxProduct(A, beg, idLastNeg - 1), maxProduct(A, idFirstNeg + 1, end));
    }
}
