package Accepted;

public class MaximumGap {

	public int maximumGap(int[] num) {
        if (num == null || num.length < 2)
            return 0;
        if (num.length == 2)
            return Math.abs(num[0] - num[1]);
        int n = num.length - 1;
        boolean[] found = new boolean[n];
        int[] min = new int[n];
        int[] max = new int[n];
        int overallMax = Integer.MIN_VALUE;
        int overallMin = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; ++i) {
            if (overallMax < num[i])
                overallMax = num[i];
            if (overallMin > num[i])
                overallMin = num[i];
        }
        for (int i = 0; i < num.length; ++i) {
            int index = getIndex(num[i], n, overallMin, overallMax);
            if (found[index] == false) {
                found[index] = true;
                min[index] = num[i];
                max[index] = num[i];
            }
            else {
                if (min[index] > num[i])
                    min[index] = num[i];
                if (max[index] < num[i])
                    max[index] = num[i];
            }
        }
        int result = Integer.MIN_VALUE;
        int pre = max[0];
        for (int i = 1; i < n; ++i) {
            if (found[i]) {
                if (result < min[i] - pre)
                    result = min[i] - pre;
                pre = max[i];
            }
        }
        return result;
    }
    
    private int getIndex(int val, int n, int overallMin, int overallMax) {
        double interval = ((double)overallMax - (double)overallMin) / (double)n;
        int i = (int)((double)(val - overallMin) / interval);
        if (i == n)
            --i;
        return i;
    }
}
