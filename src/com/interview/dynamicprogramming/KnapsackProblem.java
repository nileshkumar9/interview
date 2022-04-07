package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=bUSaenttI24&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=16
 * Kanpsack problem 0 1
 *
 * PS : ITs called 0 one because we have allowed only one element to be piced once, no duplicacy
 * If its no duplicacy its always 2 d dp, if duplicacy is allowed it will convert to
 * coin change problem where one d dp is used .
 *
 * we will be given with weight and value
 * We have to decide how to have maximum value in the knapsack for given value.
 * for given inputs it will go in 2 ^ 2
 *
 * ITs a variation of subset problem
 *
 * BF : will be to keep iterating for each elemnt. will be 2^ n
 *
 * No duplicacy allowed.
 *
 * DP : 1) Storage and meaning
 *          We will have 2d array array.. Each of cell will have for qualifying
 *          elements, what will be best available value for given bag capacity
 *
 *
 *      2) Direction
 *      3) Travel and solve
 *
 */
public class KnapsackProblem {
    public static void main(String[] args) {

        int bagCapacity = 7;

        int[] weight = {2, 5, 1, 3, 4};
        int[] vals = {15, 14, 10 ,45, 30};


        int [][] dp = new int [vals.length+1][bagCapacity+1];

        //for o row and 0 column the value will be zero
        // so we will leave it empty

        for(int i=1; i< dp.length; i++){
            for (int j=0; j< dp[0].length; j++){
                // if we are not not including current element
                // when i is not included
                dp[i][j] = dp[i-1][j];
                // if i is included, the capacity of bag should be greater then the
                // val of this element
                if ( j >= weight[i-1]){ // since we have 0 in dp which is extra
                    // once it qualifies, either it will be included of not included.
                    // if not included the value of immediate previousl rows (same column) value
                    // if indluded then, its value + remaining previous row value
                    if (dp[i-1][j] > (vals[i-1] + dp[i-1][j-weight[i-1]])){
                        dp[i][j] = dp[i-1][j];
                    } else {
                        // included and then remaining capacity weights
                        dp[i][j] = vals[i-1] + dp[i-1][j-weight[i-1]];
                    }
                }
            }
        }

        System.out.println( "Kapsact best value " + dp[weight.length][bagCapacity]);



    }
}
