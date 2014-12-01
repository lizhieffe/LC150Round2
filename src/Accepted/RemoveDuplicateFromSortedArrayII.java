package Accepted;

public class RemoveDuplicateFromSortedArrayII {

	public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int num = 1;
        int count = 1;
        int prev = A[0];
        int slow = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == prev) {
                if (count < 2) {
                    count++;
                    num++;
                    A[slow++] = A[i];
                }
            }
            else {
                prev = A[i];
                count = 1;
                num++;
                A[slow++] = A[i];
            }
        }
        return num;
    }
}
