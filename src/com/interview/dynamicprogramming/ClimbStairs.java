package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=A6mOASLl2Dg&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=2
 */
public class ClimbStairs {
    public static void main(String[] args) {

        int stairsCount = 6;
        int waysToClimb = countClimbPath(stairsCount);
        System.out.println("Total no of path to climb : " + waysToClimb);
    }

    /**
     * Logic : ITs just like solving the same problem once we climb on stairs.
     *      So lets say we take 1 step, next for this we can either take 1, 2 or 3 stairs next time
     *      calculate each value and then find the sum.
     */
    public static int countClimbPath(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }

        int n1 = countClimbPath(n - 1);
        int n2 = countClimbPath(n - 2);
        int n3 = countClimbPath(n - 3);
        int countPath = n1 + n2 + n3;

        return countPath;
    }

}
