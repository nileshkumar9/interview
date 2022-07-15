package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=jgps7MXtKRQ&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=17
 * Kanpsack problem unbounded
 *
 * PS : Its unbounded because duplicacy is allowed.
 *
 * we will be given with weight and value
 * We have to decide how to have maximum value in the knapsack for given value.
 * for given inputs it will go in 2 ^ 2
 *
 * ITs a variation of subset problem
 *
 * BruteForce : will be to keep iterating for each elemnt. will be 2^ n
 *
  *
 * DP : 1) Storage and meaning
 *          We will have 1d tabulation array array.. Length of array will be targetBagCapoacity+1
 *          Each of cell will hold the value as if the bagCapacity was this, what will be
 *          Best value that will be adjusted/put into the bag.
 *
 *
 *      2) Direction
 *          To start with 0th element and then go to the length of dp
 *      3) Travel and solve
 *          In each itteration, check for all the available values, then compare the max
 *          of each calculated value. This is a permutation style. But permutation
 *          or combinations is both same here.
 *
 *
 *  PS : If we are validating all the values, at the given index in dp, then its a permutation
 *      else if we are only considering on value in one iteration, then its a combination.
 *
 *
 */
public class KnapsackProblemUnbounded {
    public static void main(String[] args) {

        int bagCapacity = 7;

        int[] weight = {2, 5, 1, 3, 4};
        int[] vals = {15, 14, 10 ,45, 30};


        int [] dp = new int [bagCapacity+1];

        dp[0] = 0 ; // it will have 0 value always

        for(int i=1 ; i <= bagCapacity ; i++){
            int max = 0;
            for (int j=0 ; j< weight.length; j++){
                // trying all the available weights given in the input
                // We can only put the items in the bag if its weight is less the
                // bag capacity
                if (weight[j] <= i ){ // i denotes here bagCapacity at this index
                    // if we are putting say 5 then remaining bag capacity is 2
                    // so we will get the value at dp index of remaining
                    // and calculate the total by adding itself to it

                    int remainingBagCapacity = i-weight[j] >= 0 ? i-weight[j] : 0; // ArrayIndexOOB
                    int remainingBagCapacityValue = dp[remainingBagCapacity];
                    int totalBagCapacityValue = vals[j] + remainingBagCapacityValue;
                    if(totalBagCapacityValue > max){
                        max = totalBagCapacityValue;
                    }
                }
            }
            dp[i] = max;

        }

        System.out.println( "Kapsact best value " + dp[bagCapacity]);



    }
}
