package com.interview.arrays;


import java.util.ArrayList;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 *
 * Example 2:
 *
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
 *
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 * Make sure the returned intervals are also sorted.
 */
public class MergeIntervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        if (intervals == null) {
            intervals = new ArrayList<Interval>();
            intervals.add(newInterval);
            return intervals;
        } else if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        Interval toInsert = newInterval;

        int i = 0;
        while (i < intervals.size()) {
            Interval current = intervals.get(i);
            if (current.end < toInsert.start) {
                // since there is no overlap just move on without doing nothing
                i++;
                continue;
            } else if (toInsert.end < current.start) {
                intervals.add(i, toInsert);
                break;
            } else {
                toInsert.start = Math.min(current.start, toInsert.start);
                toInsert.end = Math.max(current.end, toInsert.end);
                intervals.remove(i);

            }
        }
        if (i == intervals.size()) {
            intervals.add(toInsert);
        }
        return new ArrayList<>();
    }
}