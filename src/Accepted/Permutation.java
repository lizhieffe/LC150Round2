package Accepted;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0)
            return result;
        List<Integer> remaining = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++)
            remaining.add(num[i]);
        List<Integer> solution = new ArrayList<Integer>();
        findPermute(remaining, solution, result);
        return result;
    }
    
    private void findPermute(List<Integer> remaining, List<Integer> solution, List<List<Integer>> result) {
        if (remaining.size() == 0) {
            result.add(solution);
            return;
        }
        for (int i = 0; i < remaining.size(); i++) {
            List<Integer> tmpRemaining = new ArrayList<Integer>(remaining);
            List<Integer> tmpSolution = new ArrayList<Integer>(solution);
            tmpSolution.add(tmpRemaining.remove(i));
            findPermute(tmpRemaining, tmpSolution, result);
        }
    }
}
