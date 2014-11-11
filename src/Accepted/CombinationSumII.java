package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    
public List<List<Integer>> combinationSum2(int[] num, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (num == null)
        return result;
    Arrays.sort(num);
    List<Integer> solution = new ArrayList<Integer>();
    find(num, 0, target, solution, result);
    return result;
}

private void find(int[] num, int beg, int target, List<Integer> solution, List<List<Integer>> result) {
    if (target == 0) {
        result.add(solution);
        return;
    }
    if (beg >= num.length)
        return;
    if (num[beg] > target)
        return;
    List<Integer> tmpSolution = new ArrayList<Integer>(solution);
    tmpSolution.add(num[beg]);
    find(num, beg + 1, target - num[beg], tmpSolution, result);
    for (int i = beg; i < num.length; i++) {
        if (num[i] != num[beg]) {
            find(num, i, target, solution, result);
            break;
        }
    }
}
}
