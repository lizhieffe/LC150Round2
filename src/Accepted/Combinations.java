package Accepted;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0 || k > n)
            return result;
        List<Integer> solution = new ArrayList<Integer>();
        findCombine(result, solution, 1, n, k);
        return result;
    }
    
    private void findCombine(List<List<Integer>> result, List<Integer> solution, int beg, int n, int k) {
        if (k == 0) {
            result.add(solution);
            return;
        }
        for (int i = beg; i <= n - k + 1; i++) {
            List<Integer> tmpSolution = new ArrayList<Integer>(solution);
            tmpSolution.add(i);
            findCombine(result, tmpSolution,i + 1, n, k - 1);
        }
    }
    
}
