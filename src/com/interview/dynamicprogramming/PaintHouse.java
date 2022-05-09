package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=kh48JLieeW8&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=23
 * <p>
 * This is continuation of MaximumSumNonAdjacentElements
 * Its given the cost if i apply red, blue and greeen colour to house.
 * No to adjacent house can be of same color.
 * We have to find the minimum cost to paint all house .
 * <p>
 * DP : Storage, if i apply red colour at this location what will be my minimum
 */
public class PaintHouse {

    public static void main(String[] args) {

        int numberOfHouses = 4;

        int[][] colorCost = {{1, 5, 7}, // red, green, blue cost to paint first house
            {5, 8, 4},
            {3, 2, 9},
            {1, 2, 4}};
        int[][] dp = new int[colorCost.length][colorCost[0].length];

        dp[0][0] = colorCost[0][0]; // if painting first house with red
        dp[0][1] = colorCost[0][1]; // if painting first house with blue
        dp[0][2] = colorCost[0][2]; // if painint first house with green;

        for (int i = 1; i < colorCost.length; i++) {
            // now we will fill if we have to paint in red,
            // then exclude red from previous and include blue and green
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + colorCost[i][0];
            // if we have to paint this house with blue, include min of previous red and gree
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + colorCost[i][1];
            // if we have to paint this house with blue , include min of previouse red and blue
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + colorCost[i][2];

        }

        int ans = Math.min(Math.min(dp[dp.length - 1][0], dp[dp.length - 1][1]), dp[dp.length - 1][2]);


        System.out.println("Minumum cost to paint house with no adjacent house of same color : " + ans);
    }
}
