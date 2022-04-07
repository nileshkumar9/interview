package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=A6mOASLl2Dg&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=2
 */
public class ClimbStairs {
    public static void main(String[] args) {

        int stairsCount = 6;
       // int waysToClimb = countClimbPath(stairsCount);
       // int waysToClimb = countClimbPathUsingDp(stairsCount, new int[stairsCount+1]);
        int waysToClimb = countClimbPathUsingDpTabulation(stairsCount );

        System.out.println("Total no of path to climb : " + waysToClimb);

    }

    /**
     * https://www.youtube.com/watch?v=A6mOASLl2Dg&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=2
     * Logic : Similar to recursive dp issue,
     * We will use tabulation:
     * Steps of tabulation :
     *      1) define storage and meaning
     *      2) Direction in which you will solve
     *      3) travel and solve
     *
     *  Here : We will use the extra dp array, will store the value of of the steps
     *      from 0 to the count. Next value will be calculated accordingly
     *      If we know how many ways we can go from n-1 to n, then we know from 0 to n
     */
    private static int countClimbPathUsingDpTabulation(int stairsCount) {
        // 1) storage and meaning,  Each step will have the value of count we have at given step
        int [] dp = new int[stairsCount+1];
        //2) direction will be from 0 to stairs, smallest proble is to find path from zero.
        dp[0] = 1;

        for (int i=1; i<= stairsCount ; i++){
            if(i==1){
                dp[i] = dp[i-1];
            } else if(i==2){
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }

        }
        return dp[stairsCount];
    }

    /**
     * Logic 1:
     * We will using memoization to solve this,
     * For every calculated value we are storing it in dp
     *
     * values.
     */
    private static int countClimbPathUsingDp(int stairsCount, int[] dp) {
        if (stairsCount < 0) {
            return 0;
        } else if (stairsCount == 0) {
            return 1;
        }

        if(dp[stairsCount] > 0){
            return dp[stairsCount];
        }

        int n1 = countClimbPathUsingDp(stairsCount - 1, dp);
        int n2 = countClimbPathUsingDp(stairsCount - 2, dp);
        int n3 = countClimbPathUsingDp(stairsCount - 3, dp);
        int countPath = n1 + n2 + n3;
        dp[stairsCount] = countPath; // this will stores the result for

        return countPath;
    }


    /**
     * Logic2 : ITs just like solving the same problem once we climb on stairs.
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
