package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=5KdvH15NJjc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=8
 * In given 2d array, we can start digging from left most column, and go to any of adjecent cells, but not in his column
 * Digging like this he has to go to the right most column.
 *
 * We have to find the max gold that we can collect, Each cell has the value as number of gold aavailable.
 *
 *
 * Logic :
 *      1) Storage in DP : each cell in dp will contians the max gold collected at each cell,
 *      2) Direction : We will start from right most. from this cell to the desitnation.
 *          We will solve right most column first.
 *
 *      2) direction to solve will be from bottom right of the matrix and we will go to left top
 *      3) Travel and solve :  At each cell we will take the max of next column adjacent cell and
 *         add itself and store the value in itself
 *
 *
 */
public class GoldMine {
    public static void main(String[] args) {

        int n = 2;
        int m = 2;
        int[][] arr = { {2, 3},
                        {4, 5},};

        // fill this array
        int [][] dp = new int[arr.length][arr[0].length];

        // Direction will be from bottom to top
         // we are travelling column by column so outer loop will be column
        // we have to solve the dependent column first
        for (int j = dp[0].length -1 ; j>=0 ; j--){ // column
            // rows we can solve top to bottom or bottom to top, it doesn't matter here
            for (int i = 0; i <= dp.length-1; i++){ // row
                // three steps here
                // 1) if in last column
                if (j == dp[0].length -1){
                    dp[i][j] = arr[i][j];
                }
                //2)  if in first row
                else if (i == 0){
                    // we can either go to right, or to diagonally down
                    dp[i][j] = arr[i][j] + Math.max( dp[i][j+1],dp[i+1][j+1]);
                }
                //3 ) if in last row
                else if (i == dp.length-1){
                    // He can go only to the right, or diagonally up
                    dp[i][j] = arr[i][j] + Math.max( dp[i][j+1],dp[i-1][j+1]);
                }
                //4) anywhere else
                else {
                    // it can go diagonally up, right,  diagonally down
                    dp[i][j] = arr[i][j] + Math.max(Math.max( dp[i-1][j+1],dp[i][j+1]) , dp[i+1][j+1]);

                }

            }

        }

        // to get the max, get max of first column
        int max = dp[0][0];
        for (int i=1; i <= dp.length-1 ; i++){
            if (max < dp[i][0]){
                max = dp[i][0];
            };
        }

        System.out.println("Max goldmine calculated can be " + max);



    }
}
