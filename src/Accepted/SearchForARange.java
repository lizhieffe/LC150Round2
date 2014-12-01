package Accepted;

public class SearchForARange {

	public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        if (A == null || A.length == 0)
            return result;
        int i = binarySearch(A, target, 0, A.length - 1);
        if (i == -1)
            return result;
        result[0] = searchLeft(A, target, i);
        result[1] = searchRight(A, target, i);
        return result;
    }
    
    private int binarySearch(int[] A, int target, int beg, int end) {
        if (beg > end)
            return -1;
        if (beg == end)
            return (A[beg] == target) ? beg : -1;
        int mid = beg + (end - beg) / 2;
        if (A[beg] == target)
            return beg;
        else if (A[mid] == target)
            return mid;
        else if (A[end] == target)
            return end;
        
        if (A[beg] > target || A[end] < target)
            return -1;
        
        if (A[mid] > target)
            return binarySearch(A, target, beg, mid - 1);
        else
            return binarySearch(A, target, mid + 1, end);
    }
    
    private int searchLeft(int[] A, int target, int i) {
        int j = i;
        while (j >= 0 && A[j] == target)
            j--;
        if (i != j)
            j++;
        return j;
    }
    
    private int searchRight(int[] A, int target, int i) {
        int j = i;
        while (j < A.length && A[j] == target)
            j++;
        if (i != j)
            j--;
        return j;
    }
}
