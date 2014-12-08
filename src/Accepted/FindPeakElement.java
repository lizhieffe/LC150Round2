package Accepted;

public class FindPeakElement {

	public int findPeakElement(int[] num) {
        if (num == null || num.length == 0)
            return -1;
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < num.length; i++) {
            if (num[i] >= max) {
                max = num[i];
                index = i;
            }
        }
        return index;
    }
}
