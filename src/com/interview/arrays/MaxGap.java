package com.interview.arrays;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/maximum-consecutive-gap/
 *Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 *
 * Try to solve it in linear time/space.
 *
 * Example :
 *
 * Input : [1, 10, 5]
 * Output : 5
 * Return 0 if the array contains less than 2 elements.
 *
 * You may assume that all the elements in the array are non-negative integers and
 * fit in the 32-bit signed integer range.
 * You may also assume that the difference will not overflow.
 *
 *
 * Logic : https://www.youtube.com/watch?v=fe_Ra9kMhbU
 * Sort the array in ascending order and then find the value.
 *
 */
public class MaxGap {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    static public int maximumGap(final List<Integer> A) {
        if (A.size() == 1) {
            return 0; // Base case to return 0
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            list.add(A.get(i));
        }
        Collections.sort(list); // Sort the array the array

        int maxGap = Integer.MIN_VALUE;
        for (int i = 1; i < list.size(); i++) {
            maxGap = Math.max(maxGap, (list.get(i) - list.get(i - 1)));
        }
        return maxGap;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(10);
        A.add(5);

        int result = maximumGap(A);
        System.out.print(result);
    }
}

