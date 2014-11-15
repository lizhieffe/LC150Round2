package Accepted;

public class SearchInsertPosition {

	public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0)
            return -1;
        return searchInsert(A, 0, A.length - 1, target);
    }
    
    private int searchInsert(int[] A, int beg, int end, int target) {
        if (target <= A[beg])
            return beg;
        if (target == A[end])
            return end;
        if (target > A[end])
            return end + 1;
        int mid = beg + (end - beg) / 2;
        if (A[mid] == target)
            return mid;
        if (end - beg == 1 && target > A[beg] && target < A[end])
            return end;
        if (A[mid] > target)
            return searchInsert(A, beg, mid - 1, target);
        else
            return searchInsert(A, mid + 1, end, target);
    }
}
