package Accepted;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumber {

	public String largestNumber(int[] num) {
        if (num == null || num.length == 0)
            return "";
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(num.length, new IntComparator());
        for (int i = 0; i < num.length; ++i)
            pq.add(num[i]);
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0)
            sb.insert(0, pq.poll());
        if (sb.charAt(0) == '0')
            return "0";
        else
            return sb.toString();
    }
}

class IntComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2) {
        String s1 = String.valueOf(i1);
        String s2 = String.valueOf(i2);
        if (Integer.parseInt(s1 + s2) > Integer.parseInt(s2 + s1))
            return 1;
        if (Integer.parseInt(s1 + s2) < Integer.parseInt(s2 + s1))
            return -1;
        return 0;
    }
}
