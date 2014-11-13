package Accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
        int[] result = {0, 0};
        if (numbers == null)
            return result;
        HashMap<Integer, List<Integer>> positions = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < numbers.length; i++)
            put(positions, numbers[i], i);
        Arrays.sort(numbers);
        int i = 0;
        int j = numbers.length - 1;
        boolean found = false;
        while (i < j) {
            int val = numbers[i] + numbers[j];
            if (val == target) {
                found = true;
                break;
            }
            if (val < target)
                i++;
            else if (val > target)
                j--;
        }
        if (found) {
            result[0] = get(positions, numbers[i]) + 1;
            result[1] = get(positions, numbers[j]) + 1;
        }
        Arrays.sort(result);
        return result;
    }
    
    private void put(HashMap<Integer, List<Integer>> positions, int val, int pos) {
        List<Integer> tmp = null;
        if (positions.get(val) == null) {
            tmp = new ArrayList<Integer>();
            tmp.add(pos);
        }
        else {
            tmp = positions.get(val);
            tmp.add(pos);
        }
        positions.put(val, tmp);
    }
    
    private int get(HashMap<Integer, List<Integer>> positions, int val) {
        List<Integer> tmp = positions.get(val);
        if (tmp.size() > 1) {
            return tmp.remove(0);
        }
        else
            return tmp.get(0);
    }
}
