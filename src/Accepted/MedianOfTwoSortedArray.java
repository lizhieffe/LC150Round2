package Accepted;

public class MedianOfTwoSortedArray {

	 public double findMedianSortedArrays(int A[], int B[]) {
	        if (A == null || B == null)
	            return 0;
	        if (A.length == 0 && B.length == 0)
	            return 0;
	        int n = A.length + B.length;
	        if (n % 2 == 1)
	            return findKth(A, 0, B, 0, n / 2 + 1);
	        else
	            return (findKth(A, 0, B, 0, n / 2) + findKth(A, 0, B, 0, n / 2 + 1)) / 2;
	    }
	    
	    private double findKth(int A[], int beg1, int B[], int beg2, int k) {
	        if (beg2 >= B.length)
	            return A[beg1 + k - 1];
	        if (beg1 >= A.length)
	            return B[beg2 + k - 1];
	        if (k == 1)
	            return Math.min(A[beg1], B[beg2]);
	        if (A.length < B.length) {
	            int C[] = A;
	            A = B;
	            B = C;
	            int tmp = beg1;
	            beg1 = beg2;
	            beg2 = tmp;
	        }
	        int i1 = k / 2;
	        int i2 = k / 2;
	        if (k / 2 > (B.length - beg2)) {
	            i2 = B.length - beg2;
	            i1 = k - i2;
	        }
	        if (A[beg1 + i1 - 1] > B[beg2 + i2 - 1])
	            return findKth(A, beg1, B, beg2 + i2, k - i2);
	        else
	            return findKth(A, beg1 + i1, B, beg2, k - i1);
	    }
}
