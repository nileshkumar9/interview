package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=Zobz9BXpwYE&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=6
 */
public class ClimbStairsMinimumMove {
    public static void main(String[] args) {

        int stairsCount = 10;
        //int[] stepToJump = {3,2,4,2,0,2,3,1,2,2};
        Integer [] maxJumpSize = {1,1,1,4,9,8,1,1,10,1};
        int n = stairsCount;

        // calculate to go from 0 to 10
        // Logic : take minimum at any step and add 1 to you

        // 1) storage and meaning
        // We have to store from 0 to n in how many moves we will reach
        Integer [] dp = new Integer[n + 1];

        // Every step will store how to reach destination from given step
        // example to reach 10 from 6 how many steps are required
        dp[n] =  0; // from 10 to 10 there is zero moves

        //2) Direction : it will be smaller problem to bigger. Solving to go from 10 to 10 is easy
        // so we will do it like that and store in dp
        // 10 to 10 there is 0 moves. there is one path though 10 to 10.
        // 3) travel and solve, using base case
        for(int i = n-1; i>=0; i--){
            // at every step find the minimum among give jump size
            if (maxJumpSize [i] > 0){
                // there is no move allowed form given step then it will be null
                // we will not do anythign there
                int min = Integer.MAX_VALUE;
                for(int j=1;j<=maxJumpSize[i] && i+j<dp.length;j++){
                    if(dp[i+j] != null){
                        min = Math.min(min, dp[i+j]);
                    }
                }
                if(min != Integer.MAX_VALUE){
                    dp[i] = min + 1;
                }
            }

        }





        System.out.println("Total no of path to climb : " + dp[0]);

    }

    private static int countClimbPathUsingDpTabulation(int stairsCount) {
        return 0;
    }


}
