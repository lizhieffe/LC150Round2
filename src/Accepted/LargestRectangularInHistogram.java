package Accepted;

public class LargestRectangularInHistogram {

	public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        if (height.length == 1)
            return height[0];
        int[] newHeight = new int[height.length + 2];
        newHeight[0] = 0;
        newHeight[height.length + 1] = 0;
        System.arraycopy(height, 0, newHeight, 1, height.length);
        
        int max = 0;
        int cur = newHeight[0];
        for (int i = 1; i < newHeight.length; i ++) {
            cur = newHeight[i];
            int j = i - 1;
            while (cur < newHeight[j]) {
                max = Math.max(max, newHeight[j] * (i - j));
                newHeight[j] = cur;
                j --;
            }
        }
        return max;
    }
}
