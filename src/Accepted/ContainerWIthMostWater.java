package Accepted;

public class ContainerWIthMostWater {

	public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int i = 0;
        int j = height.length - 1;
        int result = 0;
        while (i < j) {
            result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j])
                i++;
            else if (height[i] > height[j])
                j--;
            else {
                i++;
                j--;
            }
        }
        return result;
    }
}
