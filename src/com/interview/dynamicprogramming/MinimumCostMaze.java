package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=BzTIOsC0xWM&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=8
 * In given 2d array, we can take one step horizontal one vertical at a time,
 * We have to find the minimum cost while traversing from top left to bottom right of the 2 d
 * array.
 *
 * Logic :
 *      1) We wil create a similar dp 2d array. Each cell in this dp will hold the cheapest value
 *      from this cell to the desitnation.
 *      2) direction to solve will be from bottom right of the matrix and we will go to left top
 *      3)
 *
 *
 */
public class MinimumCostMaze {
    public static void main(String[] args) {

        int n = 2;
        int m = 2;
        int[][] arr = { {3, 1},
                        {4, 3},};

        // fill this array
        int [][] dp = new int[arr.length][arr[0].length];

        // Direction will be from bottom to top
        for (int i = dp.length-1 ; i>=0; i--){
            for(int j=dp[0].length-1; j>=0; j--){
                // there is always 4 scenario in this maze matrix
                //1) last cell
                if(i == dp.length-1 && j == dp[0].length-1){
                    dp[i][j] = arr[i][j];
                } else if( i == dp.length-1){
                    // 2)last row, in last row we can only go horizontly right
                    // current value of the cell and the value stored in the dp cell just next to it
                    dp[i][j] = dp[i][j+1] + arr[i][j];
                } else if (j == dp[0].length-1){
                    // 3)last column, we can only go down
                    // so the value will be current cell value + the value of dp's cell just vertically down to it
                    dp[i][j] = arr[i][j] + dp[i+1][j];
                } else {
                    // 4) all other cell, we can go either horizontally right or vertically down
                    //
                    dp[i][j] = arr[i][j] + Math.min(dp[i][j+1] , dp[i+1][j]);
                }
            }
        }

        System.out.println("Minimum cost to go from top left of maze to bottom right is " + dp[0][0]);



    }
}
