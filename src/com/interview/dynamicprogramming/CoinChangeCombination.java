package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=l_nR5X9VmaI&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=13
 * this is the next in targetSum type of problem,
 * We have infinite coins, and we have to find the number of ways in which we can
 * form the given sum.
 * E.g : 2 3 5, for given target 7, in how many ways we can make 7
 * ans : 2 2 3, 2 5 ( only two is answer)
 *
 * We will form a DP array.
 * This is to give combinations in which the the coin will come in sequence and will not be repeated.
 * E.g : 2 2 3 is only answer and we will not get 2 3 2 as answer as its a repetition
 *
 * 1) Storage and meaning : each cell will hold the value of count that we can have
 *      for given element, when we process the next element we will increase the value.
 * 2) Direction is from dp[0] to the end of targetSum. We will take each element of the input
 *    and we will then increment
 *
 * 3) Travel and solve : At each value, we will check if this alone can solved and if, this
 *      and removing the value from sum there is any other combination. We will append the
 *      combinations value from the index that is already calculated.
 */
public class CoinChangeCombination {

    public static void main(String[] args) {

        int[] input = { 2, 3, 5};
        int targetSum = 7; // trying to find the change for 7 from 2 , 3 and 5 rs coin
        int[]  dp = new int[targetSum+1];// length of dp will be target sum + 1

        dp[0] = 1; // o to pay we have 1 way

        for(int i=0 ; i< input.length; i++){
            // iterating till the coins length
            for(int j = input[i]; j < dp.length ; j++){
                // we should start from the position in dp where
                // the value should be greater than the coin value.
                dp[j] = dp[j] + dp[j-input[i]];  // calculate for self and then check for
                // the position this means if i solved for 7 rupees with 2rs coin, we will check
                // for the 5th [7-2] position.
            }
        }

        System.out.println( "Number of ways in which coin change will be formed : "+ dp[targetSum]);
    }

}
