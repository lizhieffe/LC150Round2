package Accepted;

public class SearchInRotatedSortedArray {

	public int search(int[] A, int target) {
        if (A == null || A.length == 0)
            return -1;
        return search(A, target, 0, A.length - 1);
    }
    
    private int search(int[] A, int target, int beg, int end) {
        if (A[beg] == target)
            return beg;
        if (A[end] == target)
            return end;
        if (end - beg <= 1)
            return -1;
        int mid = beg + (end - beg) / 2;
        if (A[mid] == target)
            return mid;
        if (A[beg] < A[end]) {
            if (A[beg] > target || A[end] < target)
                return -1;
            if (A[mid] > target)
                return search(A, target, beg, mid - 1);
            else
                return search(A, target, mid + 1, end);
        }
        else {
            if (A[mid] > A[beg]) {
                if (A[mid] > target && A[beg] < target)
                    return search(A, target, beg, mid - 1);
                else
                    return search(A, target, mid + 1, end);
            }
            else {
                if (A[mid] < target && A[end] > target)
                    return search(A, target, mid + 1, end);
                else
                    return search(A, target, beg, mid - 1);
            }
        }
    }
}
