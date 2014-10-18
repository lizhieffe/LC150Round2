package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

	List<List<Integer>> result = new ArrayList<List<Integer>>();
    int length;
    
    public List<List<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0)
            return result;
        
        Arrays.sort(num);
        List<Integer> numArray = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i ++)
            numArray.add(num[i]);
        List<Integer> solution = new ArrayList<Integer>();
        
        getPermute(solution, numArray);
        
        return result;
    }
    
    private void getPermute(List<Integer> solution, List<Integer> numArray) {
        if (numArray.size() == 0) {
            result.add(solution);
            return;
        }
        int last = numArray.get(0) - 1;
        for (int i = 0; i < numArray.size(); i ++) {
            if (numArray.get(i) != last) {
                List<Integer> tmpSolution = new ArrayList<Integer>(solution);
                List<Integer> tmpNumArray = new ArrayList<Integer>(numArray);
                tmpSolution.add(tmpNumArray.get(i));
                last = tmpNumArray.get(i);
                tmpNumArray.remove(i);
                getPermute(tmpSolution, tmpNumArray);
            }
        }
    }
}
