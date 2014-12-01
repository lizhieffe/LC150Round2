package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if (S == null || S.length == 0)
            return result;
        Arrays.sort(S);
        result = find(S, 0);
        return result;
    }
    
    private List<List<Integer>> find(int[] S, int beg) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (beg == S.length - 1) {
            result.add(new ArrayList<Integer>());
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(S[S.length - 1]);
            result.add(tmp);
        }
        else {
            List<List<Integer>> prevResult = find(S, beg + 1);
            List<List<Integer>> tmpResult = new ArrayList<List<Integer>>();
            for (List<Integer> l : prevResult) {
            	List<Integer> newL = new ArrayList<Integer>();
            	for (Integer in : l) {
            		newL.add(new Integer(in));
            	}
            	tmpResult.add(newL);
            }
            for (int i = 0; i < tmpResult.size(); i++) {
                tmpResult.get(i).add(0, S[beg]);
            }
            result.addAll(prevResult);
            result.addAll(tmpResult);
        }
        return result;
    }
    
    public static void main(String[] args) {
    	int[] S = {1, 2};
    	new Subsets().subsets(S);
    }
}
