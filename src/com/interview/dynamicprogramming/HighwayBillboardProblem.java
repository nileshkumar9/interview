package com.interview.dynamicprogramming;

/**
 * Q : https://www.youtube.com/watch?v=SiGqwJOvflE&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=36
 *
 * Logic :
 *      We will have two approach
 *  Approach one:
 *      1) For every Billboard, we will check the value that we have received from previous input and
 *      then we will maintain the vaue in dp array. At end we will compare the max value present in dp.
 *
 */
public class HighwayBillboardProblem {
    public static void main(String[] args) {

        //inputs
        // m = highwaylenght
        int m = 20;
        // billboardDistance array
        int[] billBoardPresent =  {6, 8, 12, 14, 16};
        // billboard reveun at given distance array
        int[] revenueForBillboard = {5, 8, 5, 3, 1};
        // int minimum distance allowed between two billboards
        int t = 3;
        //
        // Approach 1
        calculateHighwayBillBoard(m, billBoardPresent, revenueForBillboard, t);
    }

    private static int calculateHighwayBillBoard(int m, int[] billBoardPresent, int[] revenueForBillboard, int t) {

        int ans = 0;
        int [] dp = new int[billBoardPresent.length];
        // initiallly dp will have first billboardPresent value
        dp[0] = revenueForBillboard[0];

        for(int i=0; i< billBoardPresent.length; i++){
            int max =0;
            for(int j=0; j<i; j++){
                int distance = billBoardPresent[i] - billBoardPresent[j];
                // we will compare every billboard present before this billboard
                if(distance > t){
                    // if distance is greater then threshold, for all previous occurance we will take the max value
                    // till now
                    max = Math.max(max, dp[j]);
                }

            }
            // Add the max dp value before this and capture this in this dp
            dp[i] = revenueForBillboard[i] + max;
            // Add it to the answer which is max of all the dp values.
            ans = Math.max(dp[i], ans);
        }

        //
        System.out.println("Max revienue will be " + ans);
        return ans;
    }
}
