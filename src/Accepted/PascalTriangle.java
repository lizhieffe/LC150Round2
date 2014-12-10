package Accepted;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0)
        	return result;
        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        result.add(first);
        for (int i = 2; i <= numRows; i++) {
        	List<Integer> prev = result.get(result.size() - 1);
        	List<Integer> curr = new ArrayList<Integer>();
        	curr.add(1);
        	for (int j = 0; j < prev.size() - 1; j++)
        		curr.add(prev.get(j) + prev.get(j + 1));
        	curr.add(1);
        	result.add(curr);
        }
        return result;
    }
}
