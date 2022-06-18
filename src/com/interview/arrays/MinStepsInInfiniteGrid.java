package com.interview.arrays;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 * You are in an infinite 2D grid where you can move in any of the 8 directions
 *
 *  (x,y) to
 *     (x-1, y-1),
 *     (x-1, y)  ,
 *     (x-1, y+1),
 *     (x  , y-1),
 *     (x  , y+1),
 *     (x+1, y-1),
 *     (x+1, y)  ,
 *     (x+1, y+1)
 * You are given a sequence of points and the order in which you need to cover the points..
 * Give the minimum number of steps in which you can achieve it. You start from the first point.
 *
 * NOTE: This question is intentionally left slightly vague.
 * Clarify the question by trying out a few cases in the “See Expected Output” section.
 *
 *
 *
 * Input Format
 * Given two integer arrays A and B, where A[i] is x coordinate and
 *  B[i] is y coordinate of ith point respectively.
 *
 *
 *
 * Output Format
 * Return an Integer, i.e minimum number of steps.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [0, 1, 1]
 *  B = [0, 1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Given three points are: (0, 0), (1, 1) and (1, 2).
 *  It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 *
 *
 *  Logic : https://www.youtube.com/watch?v=E-P5N_8WeBI
 *  Formula : Minimum steps will be Max of (diffrence of x cordinates , difference of y coordinates of two points)
 *  find in loop and add for all given points
 */
public class MinStepsInInfiniteGrid {

    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

        int size = A.size();
        int steps = 0;

        // Size-1 is required because we need to find distance between second last element and last element
        for(int i =0 ; i< size-1 ; i++){
            int x1 = A.get(i);
            int y1 = B.get(i);
            int x2 = A.get(i + 1);
            int y2 = B.get(i + 1);
            // We will find the difference between these two points
            int xdiff = Math.abs(x1 - x2);
            int ydiff = Math.abs(y2 - y1) ;
            // Steps required will be max of difference of xdiff and ydiff
            steps = steps + Math.max(xdiff , ydiff);

        }
        return steps;
    }
}
