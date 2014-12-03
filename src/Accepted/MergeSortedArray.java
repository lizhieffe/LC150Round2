package Accepted;

public class MergeSortedArray {

	public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null || m < 0 || n < 0)
            return;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j])
                A[i + j + 1] = A[i--];
            else
                A[i + j + 1] = B[j--];
        }
        if (j >= 0)
            System.arraycopy(B, 0, A, 0, j + 1);
    }
}
