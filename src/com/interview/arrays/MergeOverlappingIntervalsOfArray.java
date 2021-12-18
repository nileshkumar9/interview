package com.interview.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/merge-overlapping-intervals/
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example:
 *
 * Given [1,3],[2,6],[8,10],[15,18],
 *
 * return [1,6],[8,10],[15,18].
 *
 * Make sure the returned intervals are sorted.
 *
 *Logic :
 * Sort the given array first, then put into stack one by one checking the end value and start value of next element.
 * Merge these values when the overlap.
 * https://www.youtube.com/watch?v=QlaDyZTCAbM
 *
 *
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 *
 *
 */
public class MergeOverlappingIntervalsOfArray {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        if(intervals.size() ==0 || intervals ==null) return new ArrayList<Interval>();
        //intervals.sort();
        //Collections.sort(intervals);
        Collections.sort(intervals, new Comparator<Interval>() {

            // Method
            // Sorting in ascending order of name
            @Override
            public int compare(Interval a, Interval b)
            {

                return Integer.compare(a.start, b.start);

            }}
        );


        Stack<Interval> stack = new Stack<Interval>();
        for(int i=0; i< intervals.size(); i++){
            if(i==0) {
                stack.push(intervals.get(i)); // push the first element
            }
            Interval top = stack.peek();
            if(intervals.get(i).start > top.end){
                stack.push(intervals.get(i));
            } else {
                top.end = Math.max(intervals.get(i).end, top.end);
            }
        }

        Stack<Interval> result = new Stack<Interval>();
        while(stack.size()>0){
            result.push(stack.pop());
        }

        ArrayList<Interval> returnArrayList = new ArrayList<Interval>();
        while(result.size()>0){
            returnArrayList.add(result.pop());

        }
        return returnArrayList;



    }
}

