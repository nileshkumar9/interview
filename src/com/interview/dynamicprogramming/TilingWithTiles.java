package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=dVT9JeUMMDE&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=27
 * <p>
 * For given floor, that is  2meter wide and n meter long
 * Tiles is 2meter long and 1meter width.
 *
 * So for tiling : We will have to find f(n-1) + f(n-2)
 *
 * Note : if we place tile vertically then its f(n-1) case.
 * If we place tile horizontally, then we will have to find the number of ways
 * in which we can place f(n-2), as above this horizontally placed tile we have only one
 * way of settling the tile.
 *
 *
 *
 */
public class TilingWithTiles {


    public static void main(String[] args) {

        int widthOfFloor = 10;

        int[] dp = new int[widthOfFloor];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=3; i<widthOfFloor ; i++){
            dp[i] = dp[i-1] + dp[i-2];

        }


         System.out.println( "Total colors : " + dp[widthOfFloor-1]);

    }
}
