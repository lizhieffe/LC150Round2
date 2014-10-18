package Accepted;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import Utils.Interval;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();

        if (intervals == null || intervals.size() == 0)
            return result;
            
        PriorityQueue<Boundary> boundaries = new PriorityQueue<Boundary>(intervals.size() * 2, new BoundaryComparator());

        for (Interval interval : intervals) {
            if (interval.start == interval.end)
                continue;
            boundaries.add(new Boundary(interval.start, 1));
            boundaries.add(new Boundary(interval.end, -1));
        }
        
        int curVal = 0;
        int curBeg = 0;
        int curEnd = 0;
        
        while (boundaries.size() > 0) {
            Boundary b = boundaries.poll();
            if (curVal == 0)
                curBeg = b.x;
            curVal += b.val;
            if (curVal == 0) {
                curEnd = b.x;
                if (result.size() > 0 && result.get(result.size() - 1).end == curBeg) {
                	Interval last = result.remove(result.size() - 1);
                	result.add(new Interval(last.start, curEnd));
                }
                else
                	result.add(new Interval(curBeg, curEnd));
            }
        }
        return result;
    }
	    
	    class Boundary {
	        int x;
	        int val;
	        Boundary (int x, int val) {
	            this.x = x;
	            this.val = val;
	        }
	    }
	    
	    class BoundaryComparator implements Comparator <Boundary> {
	        public int compare (Boundary b1, Boundary b2) {
	            if (b1.x < b2.x)
	                return -1;
	            else if (b1.x == b2.x)
	                return 0;
	            else
	                return 1;
	        }
	    }
	    
	public static void main(String[] args) {
		Interval a1 = new Interval(1, 3);
		Interval a2 = new Interval(3, 4);

		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(a1);
		intervals.add(a2);

		MergeIntervals service = new MergeIntervals();
		List<Interval> result = service.merge(intervals);
		
		System.out.println(result);
	}
}
