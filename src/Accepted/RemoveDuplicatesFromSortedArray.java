package Accepted;

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] A) {
        if (A == null)
            return 0;
        if (A.length < 2)
            return A.length;
        int prev = A[0];
        int j = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == prev)
                continue;
            else {
                A[j++] = A[i];
                prev = A[i];
            }
        }
        return j;
    }
}
