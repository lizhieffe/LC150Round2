package Accepted;

import java.util.ArrayList;
import java.util.List;

import Utils.Interval;

public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null)
            return new ArrayList<Interval>();
        
        boolean added = false;
        List<Interval> result = new ArrayList<Interval>();
        for (int i = 0; i < intervals.size(); i ++) {
            if (added == true || intervals.get(i).end < newInterval.start)
                result.add(intervals.get(i));
            else if (intervals.get(i).start > newInterval.end) {
                result.add(newInterval);
                result.add(intervals.get(i));
                added = true;
            }
            else {
                newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
                        Math.max(intervals.get(i).end, newInterval.end));
            }
        }
        if (!added)
            result.add(newInterval);
        return result;
    }
}
