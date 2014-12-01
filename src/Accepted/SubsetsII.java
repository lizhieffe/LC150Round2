package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if (num == null || num.length == 0)
            return result;
        Arrays.sort(num);
        findSubsets(num, 0, result);
        return result;
    }
    
    private void findSubsets(int[] num, int beg, List<List<Integer>> result) {
        if (beg >= num.length)
            return;
        int i = beg + 1;
        int repeat = 1;
        for (; i < num.length && num[i] == num[beg]; i++)
            repeat++;
    	List<List<Integer>> newResult = new ArrayList<List<Integer>>();
        for (i = 0; i < repeat; i++) {
        	int resultSize = result.size();
            for (int j = 0; j < resultSize; j++) {
                List<Integer> tmp = new ArrayList<Integer>();
                for (Integer in : result.get(j)) {
                    tmp.add(new Integer(in));
                }
                for (int k = 0; k <= i; k++)
                    tmp.add(num[beg]);
                newResult.add(tmp);
            }
        }
        result.addAll(newResult);
        findSubsets(num, beg + repeat, result);
    }
    
    public static void main(String[] args) {
    	int[] S = {1, 2, 2};
    	new SubsetsII().subsetsWithDup(S);
    }
}
