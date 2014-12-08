package Accepted;

public class FindMinInRotatedSortedArray {

	public int findMin(int[] num) {
        if (num == null || num.length == 0)
            return -1;
        return findMin(num, 0, num.length - 1);
    }
    
    private int findMin(int[] num, int beg, int end) {
    	if (beg == end)
    		return num[beg];
    	if (beg == end - 1)
    		return Math.min(num[beg], num[end]);
    	if (num[beg] < num[end])
    		return num[beg];
    	int mid = beg + (end - beg) / 2;
    	if (num[mid] < num[end])
    		return findMin(num, beg, mid);
    	else
    		return findMin(num, mid + 1, end);
    }
    
    public static void main(String[] args) {
    	int[] num = {3, 1, 2};
    	System.out.println(new FindMinInRotatedSortedArray().findMin(num));
    }
}
