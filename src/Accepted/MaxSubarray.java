package Accepted;

public class MaxSubarray {

	public int maxSubArray(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int max = A[0];
        int maxEndAtCurrentIndex = A[0];
        for (int i = 1; i < A.length; i++) {
            maxEndAtCurrentIndex = Math.max(maxEndAtCurrentIndex + A[i], A[i]);
            if (max < maxEndAtCurrentIndex)
                max = maxEndAtCurrentIndex;
        }
        return max;
    }
}
