package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=_c_R-uIi-zU&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=27
 *
 * <p>
 * Its similar to tiles with 2*1 tile
 * Difference here is its a M*N width area and tiles is M*1;
 * And tiles dimenstion is M*1
 * <p>
 *
 * <p>
 * So for tiling : We will have to find f(n-1) + f(n-2)
 * <p>
 * Note : if we place tile vertically then its f(n-1) case.
 * If we place tile horizontally, then we will have to find the number of ways
 * in which we can place f(n-2), as above this horizontally placed tile we have only one
 * way of settling the tile.
 */
public class TilingWithTilesMN {


    public static void main(String[] args) {

        int n=8; // width of the dimension
        int m = 3; // length of the dimension


        int [] dp = new int[n+1];

        // base cases
        for (int i=1 ; i<=n;i++){
            // if n is less then m , then we have to place all the tiles in same way vertically

            if (i<m) {
                //here placing tiles horizontall will not be possible so we will keep everything vertically
                dp[i] =1;
                
            } else if(i==m){
                dp[i] = 2;
            } else {
                // dp[i-1] = when we are placing it virtically.
                // dp[i-m] - when we are placing it horizontally.
                dp[i] = dp[i-1] + dp[i-m] ;
            }


        }


        System.out.println("Total no of ways of tiling it is : " + dp[n]);

    }
}
