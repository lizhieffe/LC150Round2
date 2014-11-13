package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length < 1)
            return result;
        List<Integer> solution = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, solution);
        return result;
    }
    
    private void combinationSum(int[] candidates, int target, int beg, List<Integer> solution) {
        if (target == 0) {
            result.add(solution);
            return;
        }
        if (target < 0 || beg >= candidates.length || target - candidates[beg] < 0)
            return;
            
        List<Integer> tmpSolution = new ArrayList<Integer>(solution);
        tmpSolution.add(candidates[beg]);
//        combinationSum(candidates, target - candidates[beg], beg + 1, tmpSolution);
        combinationSum(candidates, target - candidates[beg], beg, tmpSolution);

        int i = beg + 1;
        while (i < candidates.length) {
            if (candidates[i] != candidates[beg]) {
                combinationSum(candidates, target, i, new ArrayList<Integer>(solution));
                break;
            }
            i++;
        }
    }
   
    public static void main(String[] args) {
    	int[] candidates = {48,22,49,24,26,47,33,40,37,39,31,46,36,43,45,34,28,20,29,25,41,32,23};
    	int target = 69;
    	System.out.println(new CombinationSum().combinationSum(candidates, target));
    }
}
