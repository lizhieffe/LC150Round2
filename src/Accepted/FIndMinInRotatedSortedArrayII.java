package Accepted;

public class FIndMinInRotatedSortedArrayII {

	public int findMin(int[] num) {
        if (num == null || num.length == 0)
            return Integer.MIN_VALUE;
        return findMin(num, 0, num.length - 1);
    }
    
    private int findMin(int[] num, int beg, int end) {
        if (beg == end)
            return num[beg];
        if (beg == end - 1)
            return Math.min(num[beg], num[end]);
            
        int mid = beg + (end - beg) / 2;
        if (num[beg] < num[end])
            return num[beg];
        else if (num[mid] > num[beg] || num[mid] > num[end])
            return findMin(num, mid + 1, end);
        else if (num[mid] < num[beg] || num[mid] < num[end])
            return findMin(num, beg, mid);
        else {
            return Math.min(findMin(num, beg, mid), findMin(num, mid + 1, end));
        }
    }
}
