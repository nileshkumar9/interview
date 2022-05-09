package com.interview.dynamicprogramming;

/**
 * https://www.youtube.com/watch?v=jGywRalvoRw&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=24
 * <p>
 * This is continuation of MaximumSumNonAdjacentElements and paint House
 * <p>
 * we have been given n number of houses,
 * We will have to paint them with m number of colors such that no two adjacent houses are of same colors
 * <p>
 * We have to find the minimum cost to paint all house .
 * <p>
 * DP : Storage, if i apply red colour at this location what will be my minimum such that previous house was non-red
 * <p>
 * We will find the minumum of colors in previous row excluding the given color and add the current cost to it.
 * Each cell will contain the cost of painting if we were suppose to paint this house with this color.
 */
public class PaintHouse2ManyColor {

    public static void main(String[] args) {

        int numberOfHouses = 4;
        int numberOfColors = 3;

        // this array can be dynamically initialized with numberOFHouses and numberOfColors
        int[][] colorCost = {{1, 5, 7 }, // red, green, blue , some more color' cost to paint first house
            {5, 8, 4},
            {3, 2, 9 },
            {1, 2, 4 }};
        int[][] dp = new int[colorCost.length][colorCost[0].length];

        // first row of dp will contain same value as that of color cost
        for (int i = 0; i < colorCost[0].length; i++) {
            dp[0][i] = colorCost[0][i];
        }


        // this is of complexity n^3
        
        for (int i = 1; i < colorCost.length; i++) {
            for (int j = 0; j < colorCost[0].length; j++) {
                int minColorCostInPreviousRowEcludingThisColor = Integer.MAX_VALUE;
                // to find the minumum in previous row all colors
                for (int k = 0; k < colorCost[0].length; k++) {
                    if (k != j && minColorCostInPreviousRowEcludingThisColor > dp[i - 1][k]) {
                        minColorCostInPreviousRowEcludingThisColor = dp[i - 1][k];
                    }
                    // now cost to color this house with this color will be
                    // minimum of previous color and current color cost
                    dp[i][j] = minColorCostInPreviousRowEcludingThisColor + colorCost[i][j];
                }
            }
        }


        int ansMinColorCost = Integer.MAX_VALUE;
        for (int k = 0; k < dp[0].length; k++) {
            if (ansMinColorCost > dp[dp.length-1][k]) {
                ansMinColorCost = dp[dp.length-1][k];
            }
        }


        System.out.println("Minumum cost to paint house with no adjacent house of same color and given many colors : " + ansMinColorCost);


    }
}

