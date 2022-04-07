package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=tRpkluGqINc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=12
 * 
 * For given array, find all subset whose sum is equal to given targe
 *
 * 1) Storage and meaning : Each dp cell contains if the number being included in subset
 *      with it and without it it can build the given target sum. We will store true or false.
 *      DP column size will be given target sum. And number of rows will be 1 + array size.
 *      First column will be for 0th element.
 * 2) Direction is that we will start with first element in the array and will fill the
 *      row of given dp for it
 *
 * 3) Travel and solve : We will store if the sum is acieved either by itself,
 *      or with previous member in the group alone
 */
public class TargetSumSubset {

    public static void main(String[] args) {

        int[] input = {4,2,7,1,3};

        int targetSum = 10;
        boolean[][] dp = new boolean[input.length + 1][targetSum +1];
        for(int i=0; i< dp.length ; i++){
            for (int j=0; j< dp[0].length; j++){
                // 1) first cell differently
                if (i==0 && j==0){
                    // this is empty row 2 to 0
                    dp[i][j] = true;
                }
                // 2) first row differently
                else if (i ==0){
                    // rest of all the cells in first row will be false
                    dp[i][j] = false;
                }
                // 3) last row differently
                else if (j==0){
                    // first column will always be true
                    dp[i][j] = true;

                }
                // 4) rest of cell differently
                else{
                    // look upward if we can solve without including it
                    // look left if i participate and then other memeber in subset can solve.

                    if(dp[i-1][j] == true){
                        dp[i][j] = true;
                    } else {
                        // since dp has an extra element 0; so row will be starting
                        // a step behind
                        int val = input[i-1];
                        if (j >= val){
                            if(dp[i-1][j-val] == true){
                                dp[i][j] = true;
                            }
                        }

                    }
                }

            }
        }
        // Once we are done populating dp, we will just get the value of the cell
        // which matches with the targe
        System.out.println(dp[input.length][targetSum]);

    }

}
