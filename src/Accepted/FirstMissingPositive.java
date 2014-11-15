package Accepted;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0)
            return 1;
        for (int i = 0; i < A.length; i ++) {
            int val = A[i];
            if (A[i] <= 0 || val >= A.length)
                continue;
            if (A[val - 1] != val) {
                swap(A, val - 1, i);
                i--;
            }
        }
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1)
                return i + 1;
        }
        return A.length + 1;
    }
    
    private void swap(int[] A, int i, int j) {
        if (i != j) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}
