package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=yc0LunmJA1A&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=16
 *
 * this is the next in coin change problem. Here we will find the combinations
 *
 * We have infinite coins, and we have to find the number of ways in which we can
 * form the given sum, to find all possible permutations
 * E.g : 2 3 5, for given target 7, in how many ways we can make 7
 * ans : 2 2 3, 2 5, 232 322  ( repitition is allowed)
 *
 * We will form a DP array.
 * This is to give permutation in which the the coin sequence will be repeated.
 * E.g : 2 2 3 is one answer and we will also get 2 3 2, 3 2 2 as answer as its a repetition
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
public class CoinChangePermutationsProblem {

    public static void main(String[] args) {

        int[] coins = { 2, 3, 5, 6};
        int targetSum = 10; // trying to find the change for 10 from 2 , 3 and 5, 6 rs coin
        int[]  dp = new int[targetSum+1];

        dp[0] = 1; // 0 to pay we have 1 way

        // we will looping for full dp length
        for(int amount=1 ; amount< dp.length; amount++){
            // dp[i] will store how many ways we have to pay i amount in dp
            // iterating for all the coins at each cell
            for(int coin : coins){
                // for each coing
                if ( coin <= amount){
                    int remaingAmount = amount - coin;
                    dp[amount] = dp[amount] + dp[remaingAmount];
                    // for given coins 2 3 5 6 dp of 8 will have
                    // for eg : for dp[8] : dp[6] + dp[5] + dp[3] + dp [2]
                }
            }
        }

        System.out.println( "Number of ways in which coin permutations will be formed : "+ dp[targetSum]);
    }

}
