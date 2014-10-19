package Accepted;

import java.util.Arrays;

public class ThreeSumClosest {

	public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3)
            return 0;
        
        int result = target + Integer.MAX_VALUE / 2;
        Arrays.sort(num);
        for (int i = 0; i < num.length -2; i ++) {
            int tmp = num[i] + twoSumClosest(num, i + 1, num.length, target - num[i]);
            if (Math.abs(tmp - target) < Math.abs(result - target))
                result = tmp;
        }
        return result;
    }
    
    private int twoSumClosest(int[] num, int beg, int end, int target) {
        int i = beg;
        int j = end - 1;
        int result = target + Integer.MAX_VALUE / 2;
        while (i != j) {
            int tmp = num[i] + num[j];
            if (Math.abs(tmp - target) < Math.abs(result - target))
                result = tmp;
            if (tmp - target > 0)
                j --;
            else
                i ++;
        }
        return result;
    }
}
