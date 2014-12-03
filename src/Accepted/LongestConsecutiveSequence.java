package Accepted;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] num) {
        int max = 0;
        if (num == null || num.length == 0)
            return 0;
        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++)
            s.add(num[i]);
        for (int i = 0; i < num.length; i++) {
            int tmp = findConsecutive(num[i], s);
            if (tmp > max)
                max = tmp;
        }
        return max;
    }
    
    private int findConsecutive(int val, Set<Integer> s) {
        if (!s.contains(val))
            return 0;
        s.remove(val);
        int result = 1;
        for (int i = 1;; i++) {
            if (s.contains(val + i)) {
                result++;
                s.remove(val + i);
            }
            else
                break;
        }
        for (int i = 1;; i++) {
            if (s.contains(val - i)) {
                result++;
                s.remove(val - i);
            }
            else
                break;
        }
        return result;
    }
}
