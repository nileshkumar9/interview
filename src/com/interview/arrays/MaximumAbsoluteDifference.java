package com.interview.arrays;

import java.util.ArrayList;

/**
 * You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 *
 * f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 *
 * For example,
 *
 * A=[1, 3, -1]
 *
 * f(1, 1) = f(2, 2) = f(3, 3) = 0
 * f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 * f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 * f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
 *
 * So, we return 5.
 *
 * Logic : https://www.youtube.com/watch?v=tN8wEDNZKF4
 *
 */
public class MaximumAbsoluteDifference {

    public int maxArr(ArrayList<Integer> A) {
        int n = A.size();
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i =0 ; i< n; i++){
            max1 = Math.max(max1, (A.get(i) + i));
            max2 = Math.max(max2, (-A.get(i) + i));

            min1 = Math.min (min1, (A.get(i) + i));
            min2 = Math.min (min2, (-A.get(i) + i));

        }
        int ans = Math.max(max2-min2 , max1-min1);

        return ans;
    }
}

