package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length < 3)
            return result;
        Arrays.sort(num);
        int prev = num[0];
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || num[i] != prev) {
                combine(result, num[i], twoSum(num, i + 1, 0 - num[i]));
            }
            if (i != 0)
                prev = num[i];
        }
        return result;
    }
    
    private void combine(List<List<Integer>> result, int val, List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
        	List<Integer> tmp = list.get(i);
        	tmp.add(0, val);
            result.add(tmp);
        }
    }
    
    private List<List<Integer>> twoSum(int[] num, int beg, int val) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        int i = beg;
        int j = num.length - 1;
        while (i < j && i > 0) {
            if (num[i] + num[j] > val)
                j = prev(num, j);
            else if (num[i] + num[j] < val)
                i = next(num, i);
            else {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(num[i]);
                tmp.add(num[j]);
                solution.add(tmp);
                i = next(num, i);
                j = prev(num, j);
            }
        }
        return solution;
    }
    
    private int prev(int[] num, int j) {
        for (int k = j - 1; k >= 0; k--) {
            if (num[k] != num[j])
                return k;
        }
        return -1;
    }
    
    private int next(int[] num, int i) {
        for (int k = i + 1; k < num.length; k++) {
            if (num[k] != num[i])
                return k;
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	int[] num = {-1,0,1,2,-1,-4};
    	new ThreeSum().threeSum(num);
    }
}
